package com.example.demo.service;

import com.example.demo.model.AppUser;

public interface AuthService {

    AppUser register(String email, String password);

    String login(String email, String password);
}
