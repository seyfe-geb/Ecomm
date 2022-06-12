package com.ecomm.dto.order;

public class OrderDto {

    private double price;

    private int quantity;

    private long productId;

    private long userId;

    public OrderDto() {
    }

    public OrderDto(double price, int quantity, long productId, long userId) {
        this.price = price;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
