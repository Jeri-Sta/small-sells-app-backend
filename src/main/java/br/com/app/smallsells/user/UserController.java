package br.com.app.smallsells.user;

import br.com.app.smallsells.exception.bundle.GeneralException;
import br.com.app.smallsells.user.model.UserDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public Page<UserDto> listAll(@ParameterObject @PageableDefault(size = 10) Pageable pageable){
        return userService.listAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable @NotNull Long id){
        UserDto user = userService.listById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody @Valid UserDto user, UriComponentsBuilder uri) throws GeneralException {
        UserDto createdUser = userService.createUser(user);
        URI address = uri.path("user/{id}").buildAndExpand(createdUser.getId()).toUri();
        return ResponseEntity.created(address).body(createdUser);
    }
}
