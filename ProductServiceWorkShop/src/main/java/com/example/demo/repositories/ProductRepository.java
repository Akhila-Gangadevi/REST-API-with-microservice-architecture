package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product , Long> {
	//product - object , Long - datatype of primary key
	
 @Override
 Optional<Product> findById(Long id);
 
 @Override
 Product save(Product product);
	

}