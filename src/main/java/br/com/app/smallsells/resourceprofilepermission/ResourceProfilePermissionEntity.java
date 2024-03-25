package br.com.app.smallsells.resourceprofilepermission;

import br.com.app.smallsells.profile.ProfileEntity;
import br.com.app.smallsells.resource.ResourceEntity;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ResourceProfilePermissionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PROFILE")
    private ProfileEntity profile;

    @ManyToOne
    @JoinColumn(name = "RESOURCE")
    private ResourceEntity resource;

    public ResourceProfilePermissionEntity(ResourceProfilePermissionDTO resourceProfilePermission) {
        BeanUtils.copyProperties(resourceProfilePermission, this);
        if(resourceProfilePermission.getResource() != null) {
            this.resource = new ResourceEntity(resourceProfilePermission.getResource());
        }
        if(resourceProfilePermission.getProfile() != null) {
            this.profile = new ProfileEntity(resourceProfilePermission.getProfile());
        }
    }
}
