package com.example.Webshop;

public interface UserRepository {
    User findByUsername(String username);
}
