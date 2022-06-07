package com.ecomm.services;


import com.ecomm.models.Product;

import java.util.List;
import java.util.Optional;


public interface ProductService {

    List<Product> getAllProduct();
    Optional<Product> findByProductById(long productId);
    void saveProduct(Product product);
    void deleteProductById(long productId);
}
