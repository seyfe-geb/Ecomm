package com.ecomm.services;

import com.ecomm.dto.order.OrderDto;
import com.ecomm.dto.product.ProductDto;
import com.ecomm.models.Order;
import com.ecomm.models.Product;
import com.ecomm.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;


    @Override
    public List<OrderDto> findOrderByUserId(long userId) {
        List<Order> orders = orderRepository.findOrderByUserId(userId);
        List<OrderDto> orderDtos = new ArrayList<>();
        for(Order order :orders){
            orderDtos.add(new OrderDto(order.getPrice(),order.getQuantity(),
                    order.getProductId(), order.getUserId()
                    ));
        }
        return orderDtos;
    }


    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findOrderById(long orderId) {
        return orderRepository.findById(orderId);
    }

    @Override
    public void saveOrder(OrderDto orderDto) {
        Order order = new Order(orderDto.getPrice(), orderDto.getQuantity(), orderDto.getProductId(), orderDto.getUserId(), LocalDate.now(), LocalDate.now());
        orderRepository.save(order);
    }

    @Override
    public void deleteOrderById(long orderId) {
        orderRepository.deleteById(orderId);
    }


}
