package com.example.ejemplo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.ejemplo.Repositories.UserRepository;

@RestController
@RequestMapping("api/")
@CrossOrigin()
public class UserController {
    @Autowired
    private UserRepository taskRepository;
}
