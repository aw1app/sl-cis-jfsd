package com.sl.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sl.entity.Product;

@Repository
public interface ProductRepositry extends JpaRepository<Product, Integer> {

	List<Product> findByName(String name);

	List<Product> findByNameContaining(String name);

	List<Product> findByPrice(float price);// Exact Price Match

	List<Product> findByPriceBetween(float price1, float price2);// Range Price Match

	// Writing our own Query using JPQL...
	@Query(value = "select p from Product p where p.name = ?1 ")
	List<Product> mySearchProductsByName(String name);

	// Writing our own Query native SQL...
	@NativeQuery(value = "select * from products where name like '%?1%' ")
	List<Product> mySearchProductsByNameUsingNativeSQL(String name);

}