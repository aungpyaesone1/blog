package com.aps.demo.controller;

import com.aps.demo.entity.User;
import com.aps.demo.model.BaseResponse;
import com.aps.demo.model.LoginData;
import com.aps.demo.model.LoginResponse;
import com.aps.demo.service.UserService;
import com.aps.demo.util.JwtUtil;
import com.aps.demo.util.ResponseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("")
    public ResponseEntity<?> createUser(@RequestBody User user){
        BaseResponse res = new BaseResponse();
        long id = userService.save(user);
        res.setStatus_code(ResponseEnum.ResponseCode.SUCCESS.code());
        res.setStatus_message(ResponseEnum.ResponseMessage.SAVE_SUCCESS.message());
        res.setSyskey(id);
        return ResponseEntity.ok().body(res);
    }
    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginData loginData){
        LoginResponse res = new LoginResponse();
        User user = userService.login(loginData);
        if(user != null){
            res.setToken(jwtUtil.generateJwtToken(user.getSyskey(),user.getUsername()));
            res.setStatus_code(ResponseEnum.ResponseCode.SUCCESS.code());
            res.setStatus_message("Successful login");
        }
        else {
            res.setStatus_code(ResponseEnum.ResponseCode.NOT_FOUND.code());
            res.setStatus_message("Invalid username and password");
        }
        return ResponseEntity.ok().body(res);
    }

}
