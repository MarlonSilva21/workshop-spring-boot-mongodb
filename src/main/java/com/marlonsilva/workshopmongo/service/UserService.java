package com.marlonsilva.workshopmongo.service;

import com.marlonsilva.workshopmongo.domain.User;
import com.marlonsilva.workshopmongo.dto.UserDTO;
import com.marlonsilva.workshopmongo.repository.UserRepository;
import com.marlonsilva.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }

    public User insert(User user) {
        return userRepository.insert(user);
    }

    public User updateUser(User user) {

        findById(user.getId());

        Optional<User> newUser = userRepository.findById(user.getId());

        updateData(newUser, user);
        return userRepository.save(newUser.get());
    }

    public void deleteUser(String id) {

        findById(id);
        userRepository.deleteById(id);
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

    public void updateData(Optional<User> newUser, User user){
            newUser.get().setName(user.getName());
            newUser.get().setEmail(user.getEmail());
    }
}
