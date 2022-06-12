package com.ecomm.services;

import com.ecomm.dto.order.OrderDto;
import com.ecomm.models.Order;
import com.ecomm.dto.product.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findByOrderById(long orderId) {
        return orderRepository.findById(orderId);
    }

    @Override
    public void saveOrder(OrderDto orderDto) {
        Order order = new Order(orderDto.getPrice(), orderDto.getProductId(), orderDto.getUserId(), LocalDate.now(), LocalDate.now());
        orderRepository.save(order);
    }

    @Override
    public void deleteOrderById(long orderId) {
        orderRepository.deleteById(orderId);
    }
}
