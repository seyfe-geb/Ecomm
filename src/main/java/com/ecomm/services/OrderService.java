package com.ecomm.services;

import com.ecomm.dto.order.OrderDto;
import com.ecomm.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> getAllOrder();
    Optional<Order> findByOrderById(long orderId);
    void saveOrder(OrderDto orderdto);
    void deleteOrderById(long orderId);

}
