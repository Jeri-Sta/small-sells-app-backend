package br.com.app.smallsells.resourceprofilepermission.controller;

import br.com.app.smallsells.resourceprofilepermission.ResourceProfilePermissionDTO;
import br.com.app.smallsells.resourceprofilepermission.service.ResourceProfilePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/resource-profile-permission")
@CrossOrigin
public class ResourceProfilePermissionController {

    @Autowired
    private ResourceProfilePermissionService service;

    @GetMapping
    public List<ResourceProfilePermissionDTO> listAll() {
        return service.listAll();
    }

    @PostMapping
    public void create(@RequestBody ResourceProfilePermissionDTO resourceProfilePermissionDTO) {
        service.create(resourceProfilePermissionDTO);
    }

    @PutMapping
    public ResourceProfilePermissionDTO update(@RequestBody ResourceProfilePermissionDTO resourceProfilePermissionDTO) {
        return service.update(resourceProfilePermissionDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
