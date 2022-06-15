package com.ecomm.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private Long id;

    private String firstName;

    private String lastName;
    private String username;
    private String email;
    private List<String> roles;

    private boolean enabled;

    private boolean approvedSeller;

    private LocalDate createdAt;

    private LocalDate modifiedAt;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String city;

    private String state;

    private String zipcode;

    @Column(nullable = false)
    private String cardName;

    @Column(nullable = false)
    private String cardType;

    @Column(nullable = false, unique = true)
    private String cardNumber;

    @Column(nullable = false)
    private String cardCVV;
}
