package com.ecomm.services;

import com.ecomm.dto.order.OrderDto;
import com.ecomm.dto.product.ProductDto;
import com.ecomm.models.Order;
import com.ecomm.models.Product;
import com.ecomm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Optional<Product> findProductById(long productId) {
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
        productRepository.deleteById(productId);
    }

    @Override
    public ProductDto getProductById(Long pid) {
        Product product = productRepository.findById(pid).orElse(null);
        ProductDto productDto = new ProductDto(product.getId(), product.getProductName(), product.getPrice(),
                                                product.getProductDescription(), product.getQuantity(), product.getProductImage(),
                                                product.getUserId());
        return productDto;
    }

    @Override
    public List<ProductDto> getProductBySellerId(Long uid) {
        List<Product> products = productRepository.findProductByUserId(uid);
        List<ProductDto> productDtos = new ArrayList<>();
        for(Product product : products){
            productDtos.add(new ProductDto(product.getId(), product.getProductName(), product.getPrice(),
                    product.getProductDescription(), product.getQuantity(), product.getProductImage(),
                    product.getUserId()));
        }

        return productDtos;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for(Product product : products){
            productDtos.add(new ProductDto(product.getId(), product.getProductName(), product.getPrice(),
                    product.getProductDescription(), product.getQuantity(), product.getProductImage(),
                    product.getUserId()));
        }
        return productDtos;
    }
}
