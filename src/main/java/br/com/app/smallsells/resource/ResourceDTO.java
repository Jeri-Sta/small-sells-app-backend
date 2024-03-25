package br.com.app.smallsells.resource;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class ResourceDTO {

    private Long id;
    private String name;
    private String key;

    public ResourceDTO(ResourceEntity resource) {
        BeanUtils.copyProperties(resource, this);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ResourceDTO other = (ResourceDTO) obj;
        return Objects.equals(id, other.id);
    }
}
