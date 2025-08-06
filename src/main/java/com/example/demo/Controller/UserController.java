package com.example.demo.Controller;

import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Entity.User;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        if (userRepository.existsByMail(user.getMail())) {
            return "Cet email est déjà utilisé.";
        }
        userRepository.save(user);
        return "Utilisateur enregistré avec succès.";
    }


}
