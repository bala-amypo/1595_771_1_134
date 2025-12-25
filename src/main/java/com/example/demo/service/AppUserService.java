package com.example.demo.service;

import com.example.demo.model.AppUser;

import java.util.List;

public interface AppUserService {

    AppUser createUser(AppUser user);

    AppUser getUserById(Long id);

    AppUser getUserByEmail(String email);

    List<AppUser> getAllUsers();
}
