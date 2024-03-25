package br.com.app.smallsells.resource.service;

import br.com.app.smallsells.resource.ResourceDTO;
import br.com.app.smallsells.resource.ResourceEntity;
import br.com.app.smallsells.resource.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository repository;

    public List<ResourceDTO> listAll() {
        List<ResourceEntity> resources = repository.findAll();
        return resources.stream().map(ResourceDTO::new).toList();
    }

    public void create(ResourceDTO resourceDTO) {
        ResourceEntity resourceEntity = new ResourceEntity(resourceDTO);
        repository.save(resourceEntity);
    }

    public ResourceDTO update(ResourceDTO resourceDTO) {
        ResourceEntity resourceEntity = new ResourceEntity(resourceDTO);
        return new ResourceDTO(repository.save(resourceEntity));
    }

    public void delete(Long id) {
        repository.findById(id).ifPresent(entity -> repository.delete(entity));
    }

    public ResourceDTO findById(Long id) {
        return new ResourceDTO(repository.findById(id).orElse(null));
    }
}
