package com.ecomm.controllers;

import com.ecomm.dto.product.ProductDto;
import com.ecomm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/miu/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{pid}")
    public ProductDto getProductById(@PathVariable("pid")Long pid) {
        return productService.getProductById(pid);
    }

    @PostMapping("/addproduct")
    @PreAuthorize("hasRole('SELLER')")
    public ResponseEntity<?> addProduct(@RequestBody ProductDto productDto){
        productService.saveProduct(productDto);
        return null;
    }

    @GetMapping("/seller/{id}")
    @PreAuthorize("hasRole('SELLER')")
    public List<ProductDto> getProductsBySellerId(@PathVariable("id") long id) {
        return productService.getProductBySellerId(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SELLER')")
    public void deleteProductById(@PathVariable("id") long id){
        productService.deleteProductById(id);
    }
}
