package br.com.app.smallsells.userprofile.controller;

import br.com.app.smallsells.userprofile.UserProfileDTO;
import br.com.app.smallsells.userprofile.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user-profile")
@CrossOrigin
public class UserProfileController {

    @Autowired
    private UserProfileService service;

    @GetMapping
    public List<UserProfileDTO> listAll() {
        return service.listAll();
    }

    @PostMapping
    public void create(@RequestBody UserProfileDTO userProfileDTO) {
        service.create(userProfileDTO);
    }

    @PutMapping
    public UserProfileDTO update(@RequestBody UserProfileDTO userProfileDTO) {
        return service.update(userProfileDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
