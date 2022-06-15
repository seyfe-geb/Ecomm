package com.ecomm.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private double price;

    private int quantity;

    private long productId;

    private long userId;

    private LocalDate createdAt;

    private LocalDate modifiedAt;


    public Order(double price, int quantity, long productId, long userId, LocalDate createdAt, LocalDate modifiedAt) {
        this.price = price;
        this.quantity = quantity;
        this.productId = productId;
        this.userId = userId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
