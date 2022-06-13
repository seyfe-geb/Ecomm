package com.ecomm.services;


import com.ecomm.dto.product.ProductDto;
import com.ecomm.models.Product;

import java.util.List;
import java.util.Optional;


public interface ProductService {

    List<Product> getAllProduct();
    Optional<Product> findProductById(long productId);
    void saveProduct(ProductDto productDto);
    void deleteProductById(long productId);

    ProductDto getProductById(Long pid);

    List<ProductDto> getProductBySellerId(Long uid);

    List<ProductDto> getAllProducts();
}
