package com.aps.demo.service.Impl;

import com.aps.demo.entity.User;
import com.aps.demo.model.LoginData;
import com.aps.demo.repository.UserRepository;
import com.aps.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public long save(User user) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String date = dateTime.format(formatter);
        user.setCreateddate(date);
        user.setModifieddate(date);
        user.setRecordstatus(1);
        User res = userRepository.save(user);
        return res.getSyskey();
    }

    @Override
    public User login(LoginData loginData) {
        return userRepository.findByUsernameAndPasswordAndRecordstatus(loginData.getUsername(), loginData.getPassword(), 1);
    }
}
