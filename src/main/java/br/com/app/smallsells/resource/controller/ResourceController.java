package br.com.app.smallsells.resource.controller;

import br.com.app.smallsells.resource.ResourceDTO;
import br.com.app.smallsells.resource.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/resource")
@CrossOrigin
public class ResourceController {

    @Autowired
    private ResourceService service;

    @GetMapping
    public List<ResourceDTO> listAll() {
        return service.listAll();
    }

    @PostMapping
    public void create(@RequestBody ResourceDTO resourceDTO) {
        service.create(resourceDTO);
    }

    @PutMapping
    public ResourceDTO update(@RequestBody ResourceDTO resourceDTO) {
        return service.update(resourceDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
