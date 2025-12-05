package com.fitness.userservice.services;


import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.UserResponse;

import com.fitness.userservice.models.User;
import com.fitness.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
  private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserResponse register(RegisterRequest request){

        if(repository.existsByEmail(request.getEmail())){

            throw  new RuntimeException("Email Already Exists");
        }
            User user = new User();
            user.setEmail(request.getEmail());
            user.setFirstName(request.getFirstName());
            user.setLastName(request.getLastName());
            user.setPassword(request.getPassword());

            User savedUser = repository.save(user);

            // to give the reponse to to method
        UserResponse  userResponse = new  UserResponse();
        userResponse.setId(savedUser.getId());
        userResponse.setEmail(savedUser.getEmail());
        userResponse.setFirstName(savedUser.getFirstName());
        userResponse.setLastName(savedUser.getLastName());
        userResponse.setPassword(savedUser.getPassword());
        userResponse.setCreaedAt(savedUser.getCreaedAt());
        userResponse.setUpdatedAt(savedUser.getUpdatedAt());
           return userResponse;
    }

    public UserResponse getUserProfile(String userId) {
    User user = repository.findById(userId)
            .orElseThrow(()-> new RuntimeException("User Not Found"));

        UserResponse  userResponse = new  UserResponse();
        userResponse.setEmail(user.getEmail());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setId(user.getId());
        userResponse.setLastName(user.getLastName());
        userResponse.setPassword(user.getPassword());
        userResponse.setCreaedAt(user.getCreaedAt());
        userResponse.setUpdatedAt(user.getUpdatedAt());
        return userResponse;

    }

    public Boolean existByUserId(String userId) {
        log.info("calling User Service for "+ userId);
        return repository.existsById(userId);
    }
}
