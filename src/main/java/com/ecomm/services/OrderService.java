package com.ecomm.services;

import com.ecomm.dto.order.OrderDto;
import com.ecomm.dto.order.OrderProductDto;
import com.ecomm.dto.product.ProductDto;
import com.ecomm.dto.user.UserDto;
import com.ecomm.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> getAllOrder();
    Optional<Order> findOrderById(long orderId);
    void saveOrder(OrderDto orderdto);
    void deleteOrderById(long orderId);
    List<OrderDto> findOrderByUserId(long userId);
    List<OrderDto> getOrdersBySellerId(Long sid);
    List<OrderDto> getOrdersByProductId(Long pid);

    OrderDto getOrderById(Long id);

    OrderProductDto getOrderDetailByOrderId(Long id);

}
