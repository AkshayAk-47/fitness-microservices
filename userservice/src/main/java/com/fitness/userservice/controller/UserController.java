package com.fitness.userservice.controller;


import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.UserResponse;
import com.fitness.userservice.models.User;
import com.fitness.userservice.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
private final UserService userService;

    //To Get a user Info
    @GetMapping("/{userId}")
    public  ResponseEntity<UserResponse> getUserProfile(@PathVariable String userId){
        return ResponseEntity.ok(userService.getUserProfile(userId));
    }
    // To Create  New User
    @PostMapping("/register")
    public ResponseEntity<UserResponse>  createUser(@Valid  @RequestBody RegisterRequest request) {

        return ResponseEntity.ok(userService.register(request));
    }

    //To Validate User id is present or not For inter-communication services
    @GetMapping("/{userId}/validate")
    public  ResponseEntity<Boolean> validateUser(@PathVariable String userId){
        return ResponseEntity.ok(userService.existByUserId(userId));
    }



}
