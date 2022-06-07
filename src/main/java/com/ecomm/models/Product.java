package com.ecomm.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false)
    private String productName;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false, length = 100000)
    private String productDescription;

    @Column(nullable = false)
    private int quantity;

    private long userId;


    private String productImage;

}
