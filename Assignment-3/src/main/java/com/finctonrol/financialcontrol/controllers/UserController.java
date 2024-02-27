package com.finctonrol.financialcontrol.controllers;

import com.finctonrol.financialcontrol.exception.UserExistException;
import com.finctonrol.financialcontrol.models.UserEntity;
import com.finctonrol.financialcontrol.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {


    private final UserService userService;

    @GetMapping
    public String users(@RequestParam(name = "username", required = false) String username, Model model){
        model.addAttribute("users", userService.listUsers(username));
        return "users";
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
