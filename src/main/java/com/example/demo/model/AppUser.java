package com.example.demo.model;

public class AppUser {
    private long id;
    private String unique;
    private String password;
    private String role;

    public AppUser(){

    }

    public AppUser(String password, String role, String unique) {
        this.password = password;
        this.role = role;
        this.unique = unique;
    }

    public long getId() {
        return id;
    }

    public String getUnique() {
        return unique;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUnique(String unique) {
        this.unique = unique;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }



}
