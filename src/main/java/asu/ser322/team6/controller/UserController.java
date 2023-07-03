package asu.ser322.team6.controller;

import asu.ser322.team6.entity.User;
import asu.ser322.team6.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {
    private  final UserService userService;

    public UserController(UserService service) {
        this.userService = service;
    }


    @GetMapping("/api/user")
    public ResponseEntity<User> playlistResponse(@RequestBody String asurite){
        User user = userService.getUser(asurite);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/api/user")
    public ResponseEntity<Void> createUserResponse(@RequestBody Map<String, String> userValues){
        userService.createUser(userValues);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/api/user/{asurite}")
    public ResponseEntity<Void> updateUserResponse(@PathVariable String asurite, @RequestBody String userValues){
        userService.updateUser(asurite, userValues);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/user/{id}")
    public ResponseEntity<Void> deleteUserResponse(@PathVariable String asurite){
        userService.deleteUser(asurite);
        return ResponseEntity.ok().build();
    }
}
