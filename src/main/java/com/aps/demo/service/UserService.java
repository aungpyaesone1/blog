package com.aps.demo.service;

import com.aps.demo.entity.User;
import com.aps.demo.model.LoginData;

public interface UserService {
    public long save(User user);
    public User login(LoginData loginData);
}
