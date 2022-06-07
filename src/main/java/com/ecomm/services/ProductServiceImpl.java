package com.ecomm.services;

import com.ecomm.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductService productService;

    @Override
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @Override
    public Optional<Product> findByProductById(long productId) {
        return productService.findByProductById(productId);
    }

    @Override
    public void saveProduct(Product product) {
        productService.saveProduct(product);
    }

    @Override
    public void deleteProductById(long productId) {
       productService.deleteProductById(productId);
    }
}
