package com.ecomm.services;

import com.ecomm.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> getAllOrder();
    Optional<Order> findByOrderById(long orderId);
    void saveOrder(Order order);
    void deleteOrderById(long orderId);

}
