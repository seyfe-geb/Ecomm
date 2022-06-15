package com.ecomm.controllers;

import com.ecomm.dto.user.ApproveDto;
import com.ecomm.dto.user.UserDto;
import com.ecomm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/miu/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }

    @GetMapping("/seller")
    @PreAuthorize("hasRole('SELLER')")
    public String sellerAccess() {
        return "Seller Board.";
    }

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/sellers")
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserDto> getAllSellers(){
        return userService.getAllSellers();
    }

    @GetMapping("/sellers/unapproved")
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserDto> getUnapprovedSellers(){
        return userService.getUnapprovedSellers();
    }

    @GetMapping("/buyers")
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserDto> getAllBuyers(){
        return userService.getAllBuyers();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public UserDto getUserById(@PathVariable("id")Long id){

        return userService.getUserById(id);
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateUser(@RequestBody ApproveDto approveDto){
        userService.updateUser(approveDto);
        return null;
    }
}
