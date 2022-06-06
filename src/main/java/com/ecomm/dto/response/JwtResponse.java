package com.ecomm.dto.response;

import java.time.LocalDate;
import java.util.List;

public class JwtResponse {

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

    private String accessToken;
    private String tokenType;

    public JwtResponse() {
    }

    public JwtResponse(Long id, String firstName, String lastName,
                       String username, String email, List<String> roles,
                       boolean enabled, boolean approvedSeller,
                       LocalDate createdAt, LocalDate modifiedAt,
                       String accessToken, String tokenType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.enabled = enabled;
        this.approvedSeller = approvedSeller;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.accessToken = accessToken;
        this.tokenType = tokenType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isApprovedSeller() {
        return approvedSeller;
    }

    public void setApprovedSeller(boolean approvedSeller) {
        this.approvedSeller = approvedSeller;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDate modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
