package com.example.challenge9.Responses;

import lombok.*;

@Data
 public class RegisterResponse  {

    private String message;


    public RegisterResponse(String message) {
        this.message = message;
    }
}
