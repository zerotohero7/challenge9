package com.example.challenge9.Services;

import com.example.challenge9.Entities.Register;
import com.example.challenge9.Repositories.RegisterRepository;
import com.example.challenge9.Responses.RegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
 public class RegisterService    {
    @Autowired
     private RegisterRepository registerRepository ;

     BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder() ;

    public RegisterResponse postting(Register user)   {
        String encodedPassword = passwordEncoder.encode( user.getPassword());
        user.setPassword(encodedPassword);
        String email = user.getEmail();
        Register  existedMail =  registerRepository.findByEmail(email);

        if(existedMail == null){
            registerRepository.save(user);
            return new RegisterResponse("Registration was successfully");
        }
        else {
          return   new RegisterResponse("User already registred !!!");
        }
    }



}
