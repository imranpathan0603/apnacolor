package com.apnacolor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apnacolor.entity.Product;
import com.apnacolor.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}


	

	@Override
	public Product saveProduct(Product product) {
	    return productRepository.save(product);
	}

	@Override
	public boolean deleteProductById(Long id) {
	    if (productRepository.existsById(id)) {
	        productRepository.deleteById(id);
	        return true;
	    }
	    return false;
	}

	
	@Override
	public Optional<Product> getProductById(Long id) {
	    return productRepository.findById(id);
	}

	
//	searching
	@Override
	public List<Product> searchProducts(String keyword) {
	    return productRepository.searchByNameOrBrand(keyword.toLowerCase());
	}

	

	
}
