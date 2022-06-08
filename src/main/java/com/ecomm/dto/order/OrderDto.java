package com.ecomm.dto.order;

public class OrderDto {

    private double price;

    private long productId;

    private long userId;

    public OrderDto() {
    }

    public OrderDto(double price, long productId, long userId) {
        this.price = price;
        this.productId = productId;
        this.userId = userId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
