package com.ecomm.services;

import com.ecomm.models.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReview();

    void saveReview(Review review);

    void deleteReviewById(long reviewId);

}