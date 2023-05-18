package com.example.ejemplo.Controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ejemplo.Repositories.UserRepository;
import com.example.ejemplo.models.User;

@RestController
@RequestMapping("api/")
@CrossOrigin()
public class UserController {
    @Autowired
    private UserRepository repository;

    @PostMapping("/")
    public Map<String, Boolean> createUser(@RequestBody User user) {
        repository.save(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("saved", Boolean.TRUE);
        return response;
    }
    
    @DeleteMapping("/")
    public Map<String, Boolean> deleteUser(@RequestBody User user) {
        User userD = repository.findById(user.getId()).orElseThrow();
        repository.delete(userD);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
