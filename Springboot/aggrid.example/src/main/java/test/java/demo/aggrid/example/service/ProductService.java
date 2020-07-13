package test.java.demo.aggrid.example.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import test.java.demo.aggrid.example.model.Product;

public interface ProductService {
	List<Product> getAllProduct();
	List<Product> getProductByDate(String date1,String date2);
	void save(List<Product> products);
	void deleteAll();
}
