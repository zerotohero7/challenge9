package com.example.challenge9.Controlers;


import com.example.challenge9.Entities.Register;
import com.example.challenge9.Responses.RegisterResponse;
import com.example.challenge9.Services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterControler {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/post")
    public RegisterResponse postUser (@RequestBody Register user  )  {
        return registerService.postting(user);
    }




}
