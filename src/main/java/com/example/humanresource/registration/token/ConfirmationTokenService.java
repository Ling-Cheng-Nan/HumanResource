package com.example.humanresource.registration.token;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {
    
    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConformationToken(ConfirmationToken token){
        confirmationTokenRepository.save(token);
    }
}
