package com.ecomm.controllers;

import com.ecomm.dto.order.OrderDto;
import com.ecomm.dto.product.ProductDto;
import com.ecomm.dto.review.ReviewDto;
import com.ecomm.services.OrderService;
import com.ecomm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/miu")
public class MainController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    //All public contents go here
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/product/{pid}")
    public ProductDto getProductById(@PathVariable("pid")Long pid) {
        return productService.getProductById(pid);
    }

    @GetMapping("/products")
    public List<ProductDto> getAllProducts() {

        return productService.getAllProducts();
    }


    //All BUYER contents go here
    @GetMapping("/buyer")
    @PreAuthorize("hasRole('BUYER')")
    public String buyerAccess() {
        return "Buyer Content.";
    }

    @PostMapping("/buyer/neworder")
    @PreAuthorize("hasRole('BUYER')")
    public ResponseEntity<?> newOrder(@RequestBody OrderDto orderDto){
        orderService.saveOrder(orderDto);
        return null;
    }


    @PostMapping("/buyer/newreview")
    @PreAuthorize("hasRole('BUYER')")
    public ResponseEntity<?> newReview(@RequestBody ReviewDto reviewDto){
        return null;
    }



    //All SELLER contents go here
    @GetMapping("/seller")
    @PreAuthorize("hasRole('SELLER')")
    public String sellerAccess() {
        return "Seller Board.";
    }

    @PostMapping("/seller/addproduct")
    @PreAuthorize("hasRole('SELLER')")
    public ResponseEntity<?> addProduct(@RequestBody ProductDto productDto){
        productService.saveProduct(productDto);
        return null;
    }

    @GetMapping("/seller/products/{id}")
    @PreAuthorize("hasRole('SELLER')")
    public List<ProductDto> getProductsBySellerId(@PathVariable("id") long id) {
        return productService.getProductBySellerId(id);
    }

    @GetMapping("/seller/orders/{id}")
    @PreAuthorize("hasRole('SELLER')")
    public List<OrderDto> getOrderedItemsFromSellerBySellerId(@PathVariable("id") long id) {
        return orderService.findOrderByUserId(id);
    }

    @PostMapping("/seller/orders")
    @PreAuthorize("hasRole('SELLER')")
    public ResponseEntity<?> getAllOrders(){
        return null;
    }



    //All ADMIN contents go here
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }

    @GetMapping("/admin/unapprovedsellers")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllUnapprovedSellers() {

        return null;
    }

    @GetMapping("/admin/approveseller/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> approveSeller(@PathVariable("id") long sellerId) {

        return null;
    }
}
