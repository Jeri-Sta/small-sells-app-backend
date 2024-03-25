package br.com.app.smallsells.profile.controller;

import br.com.app.smallsells.profile.ProfileDTO;
import br.com.app.smallsells.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/profile")
@CrossOrigin
public class ProfileController {

    @Autowired
    private ProfileService service;

    @GetMapping
    public List<ProfileDTO> listAll() {
        return service.listAll();
    }

    @PostMapping
    public void create(@RequestBody ProfileDTO profileDTO) {
        service.create(profileDTO);
    }

    @PutMapping
    public ProfileDTO update(@RequestBody ProfileDTO profileDTO) {
        return service.update(profileDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
