package com.example.demo.dtos;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
public class UserDTO {

    @NotBlank(message = "Name is required")
    public String username;


    @NotBlank(message = "Password is required")
    public String password;




}