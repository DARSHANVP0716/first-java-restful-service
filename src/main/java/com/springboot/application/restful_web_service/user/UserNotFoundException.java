package com.springboot.application.restful_web_service.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND)  //whenever this exception occurs (throw in controller) spring throws
                                              // an error code status with error using @ResponseStatus annotation
public class UserNotFoundException extends RuntimeException {   //all these classes will be handled by spring boot
//    public UserNotFoundException(String message){
//        //this below super method is there in super class so we are just sending it
//        super(message);  //message is passes to the parent class, so it shows this message in response body
//    }
}

