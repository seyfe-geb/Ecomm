package com.ecomm.services;

import com.ecomm.dto.order.OrderDto;
import com.ecomm.dto.order.OrderProductDto;
import com.ecomm.dto.product.ProductDto;
import com.ecomm.models.Order;
import com.ecomm.models.Product;
import com.ecomm.repository.OrderRepository;
import com.ecomm.repository.ProductRepository;
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

    @Autowired
    ProductRepository productRepository;


    @Override
    public List<OrderDto> findOrderByUserId(long userId) {
        List<Order> orders = orderRepository.findOrderByUserId(userId);
        List<OrderDto> orderDtos = new ArrayList<>();
        for(Order order :orders){
            orderDtos.add(new OrderDto(order.getId(), order.getPrice(),order.getQuantity(),
                    order.getProductId(), order.getUserId()
                    ));
        }
        return orderDtos;
    }

    @Override
    public List<OrderDto> getOrdersBySellerId(Long sid) {
        List<Product> products = productRepository.findProductByUserId(sid);
        List<ProductDto> productDtos = new ArrayList<>();
        for(Product product : products){
            productDtos.add(new ProductDto(product.getId(), product.getProductName(), product.getPrice(),
                    product.getProductDescription(), product.getQuantity(), product.getProductImage(),
                    product.getUserId()));
        }

        List<OrderDto> orders = new ArrayList<>();
        for (ProductDto p: productDtos){
            List<Order> orders1 = orderRepository.findOrderByProductId(p.getId());
            for(Order order :orders1){
                orders.add(new OrderDto(order.getId(), order.getPrice(),order.getQuantity(),
                        order.getProductId(), order.getUserId()
                ));
            }
        }
        return orders;
    }

    @Override
    public List<OrderDto> getOrdersByProductId(Long pid) {
        List<Order> orders = orderRepository.findOrderByProductId(pid);
        List<OrderDto> orderDtos = new ArrayList<>();
        for(Order order :orders){
            orderDtos.add(new OrderDto(order.getId(), order.getPrice(),order.getQuantity(),
                    order.getProductId(), order.getUserId()
            ));
        }
        return orderDtos;
    }

    @Override
    public OrderDto getOrderById(Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        OrderDto orderDto = new OrderDto(order.getId(), order.getPrice(),order.getQuantity(),
                order.getProductId(), order.getUserId());
        return orderDto;
    }

    @Override
    public OrderProductDto getOrderDetailByOrderId(Long id) {
        OrderProductDto result = new OrderProductDto();
        Order order = orderRepository.findById(id).orElse(null);
        if(order != null){
            Product product = productRepository.findById(order.getProductId()).orElse(null);
            result = new OrderProductDto(order.getId(),product.getProductName(),
                    order.getPrice(), order.getQuantity(), product.getProductImage(),
                    order.getProductId(), order.getUserId());
        }
        return result;
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
