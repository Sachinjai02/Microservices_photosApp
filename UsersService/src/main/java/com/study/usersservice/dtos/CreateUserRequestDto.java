package com.study.usersservice.dtos;

import com.study.usersservice.models.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateUserRequestDto {
    @Size(min = 2, message = "First name should be at least 2 chars long")
    @NotNull
    private String firstName;
    @Size(min = 2, message = "Last name should be at least 2 chars long")
    @NotNull
    private String lastName;

    @Email
    @NotNull
    private String email;
    @Size(min = 8, max=20, message = "Password should be between 8 and 20 chars")
    @NotNull
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User toUser() {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }
}
