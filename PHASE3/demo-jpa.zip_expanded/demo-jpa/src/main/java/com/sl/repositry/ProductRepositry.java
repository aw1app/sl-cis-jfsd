package com.sl.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sl.entity.Product;



@Repository
public interface ProductRepositry extends JpaRepository<Product, Integer>{

}
