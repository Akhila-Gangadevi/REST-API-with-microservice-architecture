package com.example.demo.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.exception.InvalidProductIdException;
import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductService {

	ProductRepository productRepository ;
	
	
	  public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}


	  public Product getProductById(Long productId) throws InvalidProductIdException {
		  Optional<Product> optionalProduct = productRepository.findById(productId);
		  	if(optionalProduct.isEmpty()) {
		  		throw new InvalidProductIdException("Invalid productId sent to Service");
		  	}
		  	else 
		  		return optionalProduct.get();
	  }

	public Product createProduct(String title, String description , String image , double price) { 
		  Product product = new Product(); 
		  product.setTitle(title);
		  product.setDescription(description);
		  product.setImage(image); 
		  
		 Product savedProduct =  productRepository.save(product);
		 return savedProduct;
	  }
	 
	
}

