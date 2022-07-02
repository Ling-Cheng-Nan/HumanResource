package com.example.humanresource.registration;

import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class EmailValidator implements Predicate<String>{
    
    @Override
    public boolean test(String s){
        //regex to validate email 
        return true;
    }
}
