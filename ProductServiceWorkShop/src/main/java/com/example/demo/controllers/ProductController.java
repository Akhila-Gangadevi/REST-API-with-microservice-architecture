package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.*;

import com.example.demo.exception.InvalidProductIdException;
import com.example.demo.models.Product;
import com.example.demo.services.ProductService;
import com.example.demo.configs.RestTemplateConfig;
import com.example.demo.dtos.ProductDto;
import com.example.demo.dtos.UserDto;


@RestController
@RequestMapping("/products")
@Controller
public class ProductController {
	
	private ProductService productService;
	private RestTemplate restTemplate;
	
	
	public ProductController(ProductService productService ,RestTemplate restTemplate ) {
		this.productService = productService;
		this.restTemplate = restTemplate;
	}


	
	  @GetMapping("/{productId}") 
	  public ProductDto getProductById(@PathVariable Long productId) throws InvalidProductIdException {
		  Product product =  productService.getProductById(productId); 
		  
		  //calling the userService to check if the user is loggrd in
		  ResponseEntity<UserDto> responseEntity =
	                restTemplate.getForEntity("http://localhost:5151/users/2", UserDto.class);  //"http://localhost:5151/users/2", UserDto.class);
		  System.out.println(responseEntity.getBody().getEmail());
		  
		//convert product object to productDto
		  return product.from(product);
		  }
	 
	
	
	  @PostMapping("/") 
	  public Product createProduct(@RequestBody ProductDto productdto) {
		  return productService.createProduct(productdto.getTitle(),
				  productdto.getDescription(), 
				  productdto.getImage(),
				  productdto.getPrice()); 
		  }
	 

//	@GetMapping("/")
//	public String testing() {
//		return "This is just for testing!";
//	}
	
}
