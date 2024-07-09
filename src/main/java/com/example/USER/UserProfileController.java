package com.example.USER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserProfileController {
    @Autowired
    private UserprofileService userProfileService;

    @GetMapping
    public List<User> getAllUsers() {
        return userProfileService.getAllUserprofiles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> userProfile = userProfileService.getUserprofileById(id);
        return userProfile.map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public User createUser(@RequestBody User userProfile) {
        return userProfileService.createUserProfile(userProfile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userProfile) {
        try {
            return ResponseEntity.ok(userProfileService.updateUserProfile(id, userProfile));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userProfileService.deleteUserprofile(id);
        return ResponseEntity.noContent().build();
    }
}
