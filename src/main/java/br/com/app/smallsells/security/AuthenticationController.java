package br.com.app.smallsells.security;

import br.com.app.smallsells.exception.bundle.GeneralException;
import br.com.app.smallsells.security.model.AuthenticationRequest;
import br.com.app.smallsells.security.model.AuthenticationResponse;
import br.com.app.smallsells.security.model.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) throws GeneralException {
        return ResponseEntity.ok().body(authenticationService.register(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) throws GeneralException {
        return ResponseEntity.ok().body(authenticationService.authenticate(request));
    }
}
