package br.com.app.smallsells.profile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class ProfileDTO {

    private Long id;
    private String description;

    public ProfileDTO(ProfileEntity profile) {
        BeanUtils.copyProperties(profile, this);
    }
}
