package com.ecomm.services;


import com.ecomm.dto.product.ProductDto;
import com.ecomm.models.Product;

import java.util.List;
import java.util.Optional;


public interface ProductService {

    List<Product> getAllProduct();
    Optional<Product> findByProductById(long productId);
    void saveProduct(ProductDto productDto);
    void deleteProductById(long productId);
}
