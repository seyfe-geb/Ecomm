package com.ecomm.dto.order;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
public class OrderDto {

    private long id;
    private double price;

    private int quantity;

    private long productId;

    private long userId;



    public OrderDto(long id, double price, int quantity, long productId, long userId) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.productId = productId;
        this.userId = userId;
    }

}
