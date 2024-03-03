package com.example.demo.dtos;
	
	import lombok.Getter;
	import lombok.Setter;

	@Getter
	@Setter
	public class ProductDto {
		//Product DTO will contain the values that we need in the input to create a Product object.
		//Id will auto increment & count we don't want to enclose
			private String title;
		    private String description;
		    private String image;
		    private double price;	    		
		    
	}



