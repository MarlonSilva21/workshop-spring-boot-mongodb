package com.marlonsilva.workshopmongo.service;

import com.marlonsilva.workshopmongo.domain.User;
import com.marlonsilva.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
