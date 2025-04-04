package com.sl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.sl.entity.Product;

public class ProductDAO {
	
	@Autowired
	JdbcTemplate productJdbcTemplate;
	
	// NOTE name of the below method should as per what we have in main-servlet.xml
	// In main-servlet we have it as name="productJdbcTemplate"
	public void setProductJdbcTemplate(JdbcTemplate template) {
		this.productJdbcTemplate = template;
	}
	
	
	// CRUD ops
	//1. List all products from the DB.
	public List<Product> getAllProducts(){
		return productJdbcTemplate.query("SELECT * FROM PRODUCTS", new ProductRowMapper()  );
	}
	
	//2 

}


//STEP 1: Implement the RowMapper for Product entity
class ProductRowMapper implements RowMapper<Product>{

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		
		product.setId( rs.getInt("id") );
		product.setName( rs.getString("name") );
		product.setPrice( rs.getFloat("price") );
		product.setCategory( rs.getString("category") );
		
		return product;
	}
	
}
