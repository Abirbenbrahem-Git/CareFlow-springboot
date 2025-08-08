package com.example.demo.Controller;

import com.example.demo.Payload.LoginResponse;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Entity.User;

import java.util.Map;
import java.util.Optional;

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

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String mail = credentials.get("mail");
        String motdepasse = credentials.get("motdepasse");

        Optional<User> userOpt = userRepository.findByMailAndMotdepasse(mail, motdepasse);

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        Optional<User> existingUserOpt = userRepository.findById(id);

        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();

            existingUser.setCin(updatedUser.getCin());
            existingUser.setNom(updatedUser.getNom());
            existingUser.setPrenom(updatedUser.getPrenom());
            existingUser.setMail(updatedUser.getMail());
            existingUser.setNumtel(updatedUser.getNumtel());
            existingUser.setMotdepasse(updatedUser.getMotdepasse());
            existingUser.setResidence(updatedUser.getResidence());
            existingUser.setRole(updatedUser.getRole());

            userRepository.save(existingUser);
            return ResponseEntity.ok(existingUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
