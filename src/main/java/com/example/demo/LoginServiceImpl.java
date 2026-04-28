package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {

    @Override
    public Login log(String username, String password) {
        // Simple implementation for demo purposes
        if ("admin".equals(username) && "password".equals(password)) {
            Login user = new Login();
            user.setUsername(username);
            return user;
        }
        return null;
    }
}

