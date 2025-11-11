package com.apnacolor.services;



import java.util.List;
import java.util.Optional;

import com.apnacolor.entity.Product;

public interface ProductService {
    List<Product> getAllProducts();
    public Product addProduct(Product product);
   
//    Optional<Product> getProductById(Long id);
    Optional<Product> getProductById(Long id);

    Product saveProduct(Product product);
    boolean deleteProductById(Long id);
    List<Product> searchProducts(String keyword);
}
