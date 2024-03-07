package fr.iut.nd.pkdxapi.controllers;

import org.springframework.web.bind.annotation.RestController;

import fr.iut.nd.pkdxapi.models.UserDTO;
import fr.iut.nd.pkdxapi.services.UserDataService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/users")
public class UserController {

    UserDataService userDataService;

    public UserController(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
        userDataService.register(userDTO);
        return ResponseEntity.ok("User created successfully");
    }

    @GetMapping("/login")
    public ResponseEntity<String> login() {
        return  ResponseEntity.ok("User is logged");
    }

    
    
}

