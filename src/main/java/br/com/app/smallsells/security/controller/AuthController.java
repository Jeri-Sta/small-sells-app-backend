package br.com.app.smallsells.security.controller;

import br.com.app.smallsells.security.AuthenticationDTO;
import br.com.app.smallsells.security.service.AuthService;
import br.com.app.smallsells.user.UserDTO;
import br.com.app.smallsells.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO authenticationDTO) {
        return ResponseEntity.ok(authService.login(authenticationDTO));
    }

    @PostMapping(value = "/signup")
    public void signUp(@RequestBody UserDTO userDTO) {
        userService.createNewUser(userDTO);
    }
}
