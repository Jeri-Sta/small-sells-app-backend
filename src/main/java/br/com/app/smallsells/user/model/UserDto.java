package br.com.app.smallsells.user.model;

import br.com.app.smallsells.security.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String email;
    private String password;
    private String token;
    private Role role;
}
