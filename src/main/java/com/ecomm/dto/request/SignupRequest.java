package com.ecomm.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SignupRequest {

    private String firstName;

    private String lastName;

    private String email;
    private String username;

    private String password;

    private String role;

    private String street;

    private String city;

    private String state;

    private String zipcode;

    private String cardName;

    private String cardType;

    private String cardNumber;

    private String cardCVV;

}
