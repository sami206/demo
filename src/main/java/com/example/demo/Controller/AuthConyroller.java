package com.example.demo.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.UserDTO;

@RestController
@RequestMapping("/auth")
public class AuthConyroller {
    

            @PostMapping("/login")
    public ResponseEntity<String> login(@Validated @RequestBody UserDTO userdto,BindingResult bindingResult) {
    
          if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            bindingResult.getAllErrors().forEach(error -> errorMessage.append(error.getDefaultMessage()).append("\n"));
            return ResponseEntity.badRequest().body(errorMessage.toString());
        }
        
        // Handle validated user
        return ResponseEntity.ok("User created successfully");
    }
}
