package com.ecomm.dto.review;

public class ReviewDto {

    private String comment;

    private long userId;

    private long productId;

    public ReviewDto() {
    }

    public ReviewDto(String comment, long userId, long productId) {
        this.comment = comment;
        this.userId = userId;
        this.productId = productId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
