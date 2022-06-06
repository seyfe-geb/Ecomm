package com.ecomm.services;


import com.ecomm.dto.request.LoginRequest;
import com.ecomm.dto.request.SignupRequest;
import com.ecomm.dto.response.JwtResponse;
import com.ecomm.dto.response.MessageResponse;
import com.ecomm.models.ERole;
import com.ecomm.models.Role;
import com.ecomm.models.User;
import com.ecomm.repository.RoleRepository;
import com.ecomm.repository.UserRepository;
import com.ecomm.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MainServiceImpl implements MainService{

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public ResponseEntity<?> authenticateUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        User user = userRepository.findByUsername(userDetails.getUsername()).orElse(null);
        return ResponseEntity.ok(new JwtResponse(
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
                jwt,
                "Bearer"));
    }

    @Override
    public ResponseEntity<MessageResponse> registerNewUser(SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }
        // Create new user's account
        User user = new User(signUpRequest.getFirstName(), signUpRequest.getLastName(), signUpRequest.getEmail(),
                signUpRequest.getUsername(), encoder.encode(signUpRequest.getPassword()),
                true, false,
                LocalDate.now(), LocalDate.now(),
                signUpRequest.getStreet(), signUpRequest.getCity(), signUpRequest.getState(), signUpRequest.getZipcode(),
                signUpRequest.getCardName(), signUpRequest.getCardType(), signUpRequest.getCardNumber(), signUpRequest.getCardCVV(), new HashSet<Role>());
        String strRole = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();
        if (strRole == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_BUYER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            switch (strRole) {
                case "ADMIN":
                    Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(adminRole);
                    break;
                case "SELLER":
                    Role modRole = roleRepository.findByName(ERole.ROLE_SELLER)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(modRole);
                    break;
                default:
                    Role userRole = roleRepository.findByName(ERole.ROLE_BUYER)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(userRole);
            }
        }
        user.setRoles(roles);
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
