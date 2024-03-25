package br.com.app.smallsells.userprofile;

import br.com.app.smallsells.profile.ProfileEntity;
import br.com.app.smallsells.user.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user_profile")
public class UserProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "PROFILE")
    private ProfileEntity profile;

    public UserProfileEntity(UserProfileDTO userProfile) {
        BeanUtils.copyProperties(userProfile, this);
        if(userProfile.getUser() != null) {
            this.user = new UserEntity(userProfile.getUser());
        }
        if(userProfile.getProfile() != null) {
            this.profile = new ProfileEntity(userProfile.getProfile());
        }
    }
}
