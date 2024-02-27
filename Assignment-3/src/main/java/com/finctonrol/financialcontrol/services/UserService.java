package com.finctonrol.financialcontrol.services;

import com.finctonrol.financialcontrol.exception.UserExistException;
import com.finctonrol.financialcontrol.models.UserEntity;
import com.finctonrol.financialcontrol.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

@Slf4j
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserEntity getUserByUsername(String username){
        return userRepository.getByUsername(username);
    }

    public List<UserEntity> listUsers(String username){
        if(username != null) return userRepository.findByUsername(username);
        return userRepository.findAll();
    }



    public void createUser(UserEntity user) throws UserExistException {
        if(userRepository.getByUsername(user.getUsername()) != null){
            throw new UserExistException("User with same username already exist");
        }
        log.info("Saving new user: {}", user);
        userRepository.save(user);
    }



    public void deleteUser(Long id){
        log.info("User number {} deleted", id);
        userRepository.deleteById(id);
    }

    public UserEntity getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }






}
