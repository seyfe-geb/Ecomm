package com.ecomm.services;


import com.ecomm.dto.product.ProductDto;
import com.ecomm.models.Product;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Optional;


public interface ProductService {



    void saveProduct(ProductDto productDto);
    void deleteProductById(long id);

    ProductDto getProductById(Long pid);

    List<ProductDto> getProductBySellerId(Long uid);

    List<ProductDto> getAllProducts();
}
