package com.ecomm.models;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 120)
    private String password;


    private boolean enabled = true;

    private boolean approvedSeller = false;

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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList<>();



    public User(String firstName, String lastName, String email,
                String username, String password,
                boolean enabled, boolean approvedSeller,
                LocalDate createdAt, LocalDate modifiedAt,
                String street, String city, String state, String zipcode,
                String cardName, String cardType, String cardNumber, String cardCVV,
                List<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.approvedSeller = approvedSeller;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.cardName = cardName;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.cardCVV = cardCVV;
        this.roles = roles;
    }
}
