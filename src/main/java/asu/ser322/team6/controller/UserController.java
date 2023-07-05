package asu.ser322.team6.controller;

import asu.ser322.team6.entity.User;
import asu.ser322.team6.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@CrossOrigin
@RestController
public class UserController {
    private  final UserService userService;

    public UserController(UserService service) {
        this.userService = service;
    }


    @GetMapping("/api/users")
    public ResponseEntity<Set<User>> playlistResponse(){
        Set<User> users = userService.getAllUser();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/api/user")
    public ResponseEntity<User> playlistResponse(@RequestBody String asurite){
        User user = userService.getUser(asurite);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/api/user")
    public ResponseEntity<String> createUserResponse(@RequestBody Map<String, String> userValues){
        userService.createUser(userValues);
        return ResponseEntity.ok().body("Request Successful");
    }

    @PatchMapping("/api/user/{asurite}")
    public ResponseEntity<String> updateUserResponse(@PathVariable String asurite, @RequestBody String userValues){
        userService.updateUser(asurite, userValues);
        return ResponseEntity.ok().body("Request Successful");
    }

    @DeleteMapping("/api/user/{id}")
    public ResponseEntity<String> deleteUserResponse(@PathVariable String asurite){
        userService.deleteUser(asurite);
        return ResponseEntity.ok().body("Request Successful");
    }
}
