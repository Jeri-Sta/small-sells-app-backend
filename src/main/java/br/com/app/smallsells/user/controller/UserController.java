package br.com.app.smallsells.user.controller;

import br.com.app.smallsells.user.UserDTO;
import br.com.app.smallsells.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<UserDTO> listAll() {
        return service.listAll();
    }

    @PostMapping
    public void create(@RequestBody UserDTO userDTO) {
        service.create(userDTO);
    }

    @PutMapping
    public UserDTO update(@RequestBody UserDTO userDTO) {
        return service.update(userDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
