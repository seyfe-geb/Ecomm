package com.ecomm.services;


import com.ecomm.dto.request.LoginRequest;
import com.ecomm.dto.request.SignupRequest;
import com.ecomm.dto.response.MessageResponse;
import org.springframework.http.ResponseEntity;

public interface MainService {

    ResponseEntity<MessageResponse> registerNewUser(SignupRequest signupRequest);

    public ResponseEntity<?> authenticateUser(LoginRequest loginRequest);
}
