package com.ecomm.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/miu")
public class MainController {

    //All public contents go here
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }


    //All BUYER contents go here
    @GetMapping("/buyer")
    @PreAuthorize("hasRole('BUYER')")                       //("hasRole('ADMIN') or hasRole('SELLER')
    public String userAccess() {
        return "Buyer Content.";
    }



    //All SELLER contents go here
    @GetMapping("/seller")
    @PreAuthorize("hasRole('SELLER')")
    public String moderatorAccess() {
        return "Seller Board.";
    }


    //All ADMIN contents go here
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
}
