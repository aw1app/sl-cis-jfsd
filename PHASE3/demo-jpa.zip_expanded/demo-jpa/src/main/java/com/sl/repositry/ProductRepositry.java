package com.sl.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sl.entity.Product;



@Repository
public interface ProductRepositry extends JpaRepository<Product, Integer>{
	
	List<Product> findByName(String name);
	
	List<Product> findByPrice(float price);

}
