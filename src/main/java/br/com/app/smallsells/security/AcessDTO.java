package br.com.app.smallsells.security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcessDTO {

    private String token;

    public AcessDTO(String token) {
        super();
        this.token = token;
    }
}