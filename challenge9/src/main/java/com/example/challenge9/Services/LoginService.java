package com.example.challenge9.Services;


import com.example.challenge9.Entities.Login;
import com.example.challenge9.Entities.Register;
import com.example.challenge9.Repositories.RegisterRepository;
import com.example.challenge9.Responses.RegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class LoginService {

    @Autowired
    private RegisterRepository registerRepository;


    public RegisterResponse logging(Login user) {
        String loginPassword = user.getPassword();
        String loginEmail = user.getEmail();
        Register existedUser = registerRepository.findByEmail(loginEmail);

        if (existedUser != null){
            String registerPassword = registerRepository.findByEmail(loginEmail).getPassword();
            if (loginPassword.equals(registerPassword)) {
                return new RegisterResponse( "access");
             } else {
            return new RegisterResponse( "password is no valid !!");
                }
             }
        else {
            return new RegisterResponse( "mail is not exist !!");
        }
    }









}











