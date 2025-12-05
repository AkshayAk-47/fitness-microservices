package com.fitness.userservice.dto;

import lombok.Data;
import java.time.LocalDateTime;

public class UserResponse {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserResponse(String id, String email, String password, String firstName, String lastName, LocalDateTime creaedAt, LocalDateTime updatedAt) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.creaedAt = creaedAt;
        this.updatedAt = updatedAt;
    }

    public UserResponse() {
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", creaedAt=" + creaedAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCreaedAt(LocalDateTime creaedAt) {
        this.creaedAt = creaedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDateTime getCreaedAt() {
        return creaedAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDateTime creaedAt;
    private LocalDateTime updatedAt;
}
