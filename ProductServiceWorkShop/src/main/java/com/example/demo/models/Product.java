package com.example.demo.models;

import jakarta.persistence.Entity;
import com.example.demo.controllers.ProductController;
import com.example.demo.dtos.ProductDto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
	    private String title;
	    private String description;
	    private String image;
	    private double price;
	    private int inventoryCount;
	
	    
	    //Convert product object to product dto
	    public ProductDto from(Product product) {
	    	
	    	ProductDto productdto = new ProductDto();
	    	productdto.setTitle(product.getTitle());
	    	productdto.setDescription(product.getDescription());
	    	productdto.setImage(product.getImage());
	    	productdto.setPrice(product.getPrice());
	    	
	    	return productdto;
	    }

}
