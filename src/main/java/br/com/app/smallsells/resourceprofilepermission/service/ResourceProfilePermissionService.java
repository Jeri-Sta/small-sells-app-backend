package br.com.app.smallsells.resourceprofilepermission.service;

import br.com.app.smallsells.resourceprofilepermission.ResourceProfilePermissionDTO;
import br.com.app.smallsells.resourceprofilepermission.ResourceProfilePermissionEntity;
import br.com.app.smallsells.resourceprofilepermission.repository.ResourceProfilePermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceProfilePermissionService {

    @Autowired
    private ResourceProfilePermissionRepository repository;

    public List<ResourceProfilePermissionDTO> listAll() {
        List<ResourceProfilePermissionEntity> resourceProfilePermissions = repository.findAll();
        return resourceProfilePermissions.stream().map(ResourceProfilePermissionDTO::new).toList();
    }

    public void create(ResourceProfilePermissionDTO resourceProfilePermissionDTO) {
        ResourceProfilePermissionEntity resourceProfilePermissionEntity = new ResourceProfilePermissionEntity(resourceProfilePermissionDTO);
        repository.save(resourceProfilePermissionEntity);
    }

    public ResourceProfilePermissionDTO update(ResourceProfilePermissionDTO resourceProfilePermissionDTO) {
        ResourceProfilePermissionEntity resourceProfilePermissionEntity = new ResourceProfilePermissionEntity(resourceProfilePermissionDTO);
        return new ResourceProfilePermissionDTO(repository.save(resourceProfilePermissionEntity));
    }

    public void delete(Long id) {
        repository.findById(id).ifPresent(entity -> repository.delete(entity));
    }

    public ResourceProfilePermissionDTO findById(Long id) {
        return new ResourceProfilePermissionDTO(repository.findById(id).orElse(null));
    }
}
