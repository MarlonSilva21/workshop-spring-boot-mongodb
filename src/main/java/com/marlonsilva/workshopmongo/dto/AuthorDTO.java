package com.marlonsilva.workshopmongo.dto;

import com.marlonsilva.workshopmongo.domain.User;

import java.io.Serializable;

public class AuthorDTO implements Serializable {

    private String id;
    private String name;

    public AuthorDTO() {

    }

    public AuthorDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();

    }

}
