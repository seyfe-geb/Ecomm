package com.ecomm.services;

import com.ecomm.dto.user.UserDto;
import com.ecomm.models.ERole;
import com.ecomm.models.Role;
import com.ecomm.models.User;
import com.ecomm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> getAllSellers() {
        List<User> sellers = userRepository.findAll();
        sellers = sellers.stream()
                .filter(s -> {
                    List<String> roles = s.getRoles().stream().map(r -> r.getName().toString()).collect(Collectors.toList());
                    return roles.contains("ROLE_SELLER");
                })
                .collect(Collectors.toList());

        List<UserDto> returnSellers = new ArrayList<>();
        for(User user : sellers){
            List<String> roles = user.getRoles().stream()
                    .map(r -> r.getName().toString())
                    .collect(Collectors.toList());
            returnSellers.add(new UserDto(
                    user.getId(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getUsername(),
                    user.getEmail(),
                    roles,
                    user.isEnabled(),
                    user.isApprovedSeller(),
                    user.getCreatedAt(),
                    user.getModifiedAt(),
                    user.getStreet(),
                    user.getCity(),
                    user.getState(),
                    user.getZipcode(),
                    user.getCardName(),
                    user.getCardType(),
                    user.getCardNumber(),
                    user.getCardCVV()
            ));
        }
        return returnSellers;
    }

    @Override
    public List<UserDto> getAllBuyers() {
        List<User> buyers = userRepository.findAll();
        buyers = buyers.stream()
                .filter(s -> {
                    List<String> roles = s.getRoles().stream().map(r -> r.getName().toString()).collect(Collectors.toList());
                    return roles.contains("ROLE_BUYER");
                })
                .collect(Collectors.toList());

        List<UserDto> returnBuyers = new ArrayList<>();
        for(User user : buyers){
            List<String> roles = user.getRoles().stream()
                    .map(r -> r.getName().toString())
                    .collect(Collectors.toList());
            returnBuyers.add(new UserDto(
                    user.getId(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getUsername(),
                    user.getEmail(),
                    roles,
                    user.isEnabled(),
                    user.isApprovedSeller(),
                    user.getCreatedAt(),
                    user.getModifiedAt(),
                    user.getStreet(),
                    user.getCity(),
                    user.getState(),
                    user.getZipcode(),
                    user.getCardName(),
                    user.getCardType(),
                    user.getCardNumber(),
                    user.getCardCVV()
            ));
        }
        return returnBuyers;
    }

    @Override
    public List<UserDto> getUnapprovedSellers() {
        List<User> sellers = userRepository.findByApprovedSeller(false);
        sellers = sellers.stream()
                .filter(s -> {
                    List<String> roles = s.getRoles().stream().map(r -> r.getName().toString()).collect(Collectors.toList());
                    return roles.contains("ROLE_SELLER");
                })
                .collect(Collectors.toList());

        List<UserDto> returnSellers = new ArrayList<>();
        for(User user : sellers){
            List<String> roles = user.getRoles().stream()
                    .map(r -> r.getName().toString())
                    .collect(Collectors.toList());
            returnSellers.add(new UserDto(
                    user.getId(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getUsername(),
                    user.getEmail(),
                    roles,
                    user.isEnabled(),
                    user.isApprovedSeller(),
                    user.getCreatedAt(),
                    user.getModifiedAt(),
                    user.getStreet(),
                    user.getCity(),
                    user.getState(),
                    user.getZipcode(),
                    user.getCardName(),
                    user.getCardType(),
                    user.getCardNumber(),
                    user.getCardCVV()
            ));
        }
        return returnSellers;
    }
}
