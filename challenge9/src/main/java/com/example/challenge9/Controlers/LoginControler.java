package com.example.challenge9.Controlers;


import com.example.challenge9.Entities.Login;
import com.example.challenge9.Responses.RegisterResponse;
import com.example.challenge9.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginControler {

    @Autowired
    private LoginService loginService;

    @PostMapping("/post")
    public RegisterResponse loginUser(@RequestBody Login user){
        return   loginService.logging(user);
    }
}
