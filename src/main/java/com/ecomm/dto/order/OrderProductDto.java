package com.ecomm.dto.order;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
public class OrderProductDto {

    private long orderId;

    private String productName;

    private double price;

    private int quantity;

    private String productImage;

    private long productId;

    private long userId;



    public OrderProductDto(long orderId, String productName, double price, int quantity,
                           String productImage, long productId, long userId) {
        this.orderId = orderId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productImage = productImage;
        this.productId = productId;
        this.userId = userId;
    }
}
