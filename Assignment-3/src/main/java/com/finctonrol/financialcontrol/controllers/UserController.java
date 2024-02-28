package com.finctonrol.financialcontrol.controllers;

import com.finctonrol.financialcontrol.exception.UserExistException;
import com.finctonrol.financialcontrol.exception.UserNotFoundException;
import com.finctonrol.financialcontrol.models.UserEntity;
import com.finctonrol.financialcontrol.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {


    private final UserService userService;

    @GetMapping
    public ResponseEntity getAllUsers(){
        List<UserEntity> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity createUser(@Valid @RequestBody UserEntity user){
        try {
            userService.createUser(user);
            return ResponseEntity.ok("User created");
        }catch (UserExistException uee){
            return ResponseEntity.badRequest().body(uee.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("ERROR");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @RequestBody UserEntity newUser) throws UserNotFoundException {
        UserEntity updatedUser = userService.updateUser(id, newUser);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("User deleted");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Failed to delete user" + e.getMessage());
        }
    }



}
