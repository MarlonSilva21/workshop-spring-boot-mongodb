package com.marlonsilva.workshopmongo.resources;

import com.marlonsilva.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {

        User maria = new User("jsadj", "Maria brown", "maria@gmail.com");
        User alex = new User("2", "Alex green", "alex@gmail.com");

        List<User> listUsers = Arrays.asList(maria, alex);

        return ResponseEntity.ok().body(listUsers);
    }

}
