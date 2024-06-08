package com.example.demo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dtos.UserDTO;

// @RestController
// @RequestMapping("/api")
public class controller { 

@GetMapping("/hello/{name}/{age}") 
public void insert(@PathVariable("name") String name, @PathVariable("age") int age) { 
		
	// Print and display name and age 
	System.out.println(name); 
	System.out.println(age); 
}


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