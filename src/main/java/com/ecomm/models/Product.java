package com.ecomm.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Data
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

    private String productImage;

    private long userId;




    public Product(String productName, double price, String productDescription, int quantity, String productImage, long userId) {
        this.productName = productName;
        this.price = price;
        this.productDescription = productDescription;
        this.quantity = quantity;
        this.productImage = productImage;
        this.userId = userId;
    }
}
