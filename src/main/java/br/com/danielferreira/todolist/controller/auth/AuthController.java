package br.com.danielferreira.todolist.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.danielferreira.todolist.entity.user.User;
import br.com.danielferreira.todolist.entity.user.dtos.AuthDTO;
import br.com.danielferreira.todolist.entity.user.dtos.RegisterDTO;
import br.com.danielferreira.todolist.entity.user.dtos.TokenDTO;
import br.com.danielferreira.todolist.infra.security.TokenService;
import br.com.danielferreira.todolist.repository.user.UserRepository;
import jakarta.validation.Valid;



@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signin")
    public ResponseEntity signin(@RequestBody @Valid AuthDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.name(), data.password());
        var auth = authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new TokenDTO(token));

    }

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody @Valid RegisterDTO data) {
        if(this.userRepository.findByName(data.name())!= null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.name(), data.email(), encryptedPassword, data.role());

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }

    
}
