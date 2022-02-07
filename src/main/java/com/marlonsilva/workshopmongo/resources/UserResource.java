package com.marlonsilva.workshopmongo.resources;

import com.marlonsilva.workshopmongo.domain.User;
import com.marlonsilva.workshopmongo.dto.UserDTO;
import com.marlonsilva.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {

        List<User> listUsers = userService.findAll();
        List<UserDTO> listUsersDTO = listUsers.stream().map(UserDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(listUsersDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable String id) {

        User user = userService.findById(id);
        UserDTO userDTO = new UserDTO(user);

        return ResponseEntity.ok().body(userDTO);
    }

}
