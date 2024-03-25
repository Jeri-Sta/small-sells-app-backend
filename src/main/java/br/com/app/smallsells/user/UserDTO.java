package br.com.app.smallsells.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String name;
    private String login;
    private String password;
    private String email;
    private UserSituationType userSituationType;

    public UserDTO(UserEntity user) {
        BeanUtils.copyProperties(user, this);
    }
}
