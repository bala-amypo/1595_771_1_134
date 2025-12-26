package com.example.demo.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {

    private Long id;
    private String email;
    private String password;
    private String fullName;
    private UserRole role;
}
