package br.com.app.smallsells.security.service;

import br.com.app.smallsells.security.AcessDTO;
import br.com.app.smallsells.security.AuthenticationDTO;
import br.com.app.smallsells.security.jwt.JwtUtils;
import br.com.app.smallsells.user.service.UserDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    public AcessDTO login(AuthenticationDTO authenticationDTO) {

        try {
            UsernamePasswordAuthenticationToken userAuth =
                    new UsernamePasswordAuthenticationToken(authenticationDTO.getUsername(), authenticationDTO.getPassword());

            Authentication authentication = authenticationManager.authenticate(userAuth);

            UserDetailImpl userDetail = (UserDetailImpl) authentication.getPrincipal();

            String token = jwtUtils.generateTokenFromUserDetailsImpl(userDetail);

            return new AcessDTO(token);
        } catch (BadCredentialsException e) {
            //TODO login ou senha invalido
        }
        return new AcessDTO("Acesso negado");
    }
}
