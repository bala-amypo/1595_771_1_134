package com.example.demo.controller;

import com.example.demo.model.AppUser;
import com.example.demo.service.AppUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class AppUserController {

    private final AppUserService service;

    public AppUserController(AppUserService service) {
        this.service = service;
    }

    @PostMapping
    public AppUser create(@RequestBody AppUser user) {
        return service.createUser(user);
    }

    @GetMapping("/{id}")
    public AppUser getById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @GetMapping
    public List<AppUser> getAll() {
        return service.getAllUsers();
    }

    @GetMapping("/email/{email}")
    public AppUser getByEmail(@PathVariable String email) {
        return service.getUserByEmail(email);
    }
}
