package br.com.app.smallsells.security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationDTO {

    private String username;
    private String password;
}
