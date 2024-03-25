package br.com.app.smallsells.resourceprofilepermission;

import br.com.app.smallsells.profile.ProfileDTO;
import br.com.app.smallsells.resource.ResourceDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class ResourceProfilePermissionDTO {

    private Long id;
    private ProfileDTO profile;
    private ResourceDTO resource;

    public ResourceProfilePermissionDTO(ResourceProfilePermissionEntity resourceProfilePermission) {
        BeanUtils.copyProperties(resourceProfilePermission, this);
        if(resourceProfilePermission.getResource() != null) {
            this.resource = new ResourceDTO(resourceProfilePermission.getResource());
        }
        if(resourceProfilePermission.getProfile() != null) {
            this.profile = new ProfileDTO(resourceProfilePermission.getProfile());
        }
    }
}
