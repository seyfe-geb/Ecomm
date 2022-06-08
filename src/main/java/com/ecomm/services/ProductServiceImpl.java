package com.ecomm.services;

import com.ecomm.models.Product;
import com.ecomm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {

//        return productRepository.getAllProduct();
        return null;
    }

    @Override
    public Optional<Product> findByProductById(long productId) {
//        return productRepository.findByProductById(productId);
        return null;
    }

    @Override
    public void saveProduct(ProductDto productDto) {
        Product product = new Product(productDto.getProductName(), productDto.getPrice(), productDto.getProductDescription(),
                            productDto.getQuantity(), productDto.getProductImage(), productDto.getUserId());
        productRepository.save(product);
    }

    @Override
    public void deleteProductById(long productId) {

//        productRepository.deleteProductById(productId);
    }
}
