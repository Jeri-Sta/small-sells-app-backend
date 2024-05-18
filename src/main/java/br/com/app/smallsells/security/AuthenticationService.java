package br.com.app.smallsells.security;

import br.com.app.smallsells.exception.bundle.AuthenticationAppException;
import br.com.app.smallsells.exception.bundle.GeneralException;
import br.com.app.smallsells.security.jwt.JwtService;
import br.com.app.smallsells.security.model.*;
import br.com.app.smallsells.user.UserRepository;
import br.com.app.smallsells.user.model.User;
import br.com.app.smallsells.utils.GeneralMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final RegisterRequestValidator registerRequestValidator;
    private final AuthenticationRequestValidator authenticationRequestValidator;

    public AuthenticationResponse register(RegisterRequest request) throws GeneralException {
        registerRequestValidator.validateFields(request);
        var email = userRepository.findByEmail(request.getEmail());
        if(email.isPresent()){
            throw new AuthenticationAppException(GeneralMessages.EMAIL_ALREADY_REGISTERED);
        }
        var user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) throws GeneralException {
        authenticationRequestValidator.validateFields(request);
        var user = userRepository.findByEmail(request.getEmail());
        if(user.isEmpty()){
            throw new AuthenticationAppException(GeneralMessages.EMAIL_NOT_FOUND);
        }
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        } catch (AuthenticationException e) {
            throw new AuthenticationAppException(GeneralMessages.LOGIN_FAILED);
        }
        var jwtToken = jwtService.generateToken(user.get());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
