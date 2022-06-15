package com.ecomm.dto.product;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {

    private long id;
    private String productName;

    private double price;

    private String productDescription;

    private int quantity;

    private String productImage;
    private long userId;
}
