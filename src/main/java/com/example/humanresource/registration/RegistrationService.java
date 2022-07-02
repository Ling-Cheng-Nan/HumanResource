package com.example.humanresource.registration;

import org.springframework.stereotype.Service;

import com.example.humanresource.appuser.AppUser;
import com.example.humanresource.appuser.AppUserRole;
import com.example.humanresource.appuser.AppUserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        //check the email is valid or not 
        boolean isValidEmail = emailValidator.
                test(request.getEmail());
        
        if (!isValidEmail){
            throw new IllegalStateException("email not valid");
        }

        return appUserService.signUpUser(
            new AppUser(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),
                AppUserRole.USER
            )
            );
    }
    
}
