package com.ecomm.controllers;

import com.ecomm.dto.order.OrderDto;
import com.ecomm.dto.order.OrderProductDto;
import com.ecomm.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/miu/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('BUYER') or hasRole('SELLER')")
    public void deleteOrderById(@PathVariable("id") long id){
        orderService.deleteOrderById(id);
    }

    @GetMapping("/productdetail/{id}")
    @PreAuthorize("hasRole('BUYER') or hasRole('SELLER')")
    public OrderProductDto getOrderDetailByOrderId(@PathVariable("id")Long id){
        return orderService.getOrderDetailByOrderId(id);
    }

    @GetMapping("/seller/{id}")
    @PreAuthorize("hasRole('SELLER')")
    public List<OrderDto> getOrderedItemsFromSellerBySellerId(@PathVariable("id") long id) {
        return orderService.getOrdersBySellerId(id);
    }

    @GetMapping("/buyer/{id}")
    @PreAuthorize("hasRole('BUYER')")
    public List<OrderDto> getBuyerOrders(@PathVariable("id")Long id){
        return orderService.findOrderByUserId(id);
    }

    @PostMapping("/neworder")
    @PreAuthorize("hasRole('BUYER')")
    public ResponseEntity<?> newOrder(@RequestBody OrderDto orderDto){
        orderService.saveOrder(orderDto);
        return null;
    }
}
