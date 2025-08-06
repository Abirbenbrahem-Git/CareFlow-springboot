package com.example.demo.Controller;

import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Entity.User;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if (userRepository.existsByMail(user.getMail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("{\"message\": \"Cet email est déjà utilisé.\"}");
        }
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("{\"message\": \"Utilisateur enregistré avec succès.\"}");
    }


}
