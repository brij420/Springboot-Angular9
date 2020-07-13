package test.java.demo.aggrid.example.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import test.java.demo.aggrid.example.model.Product;
import test.java.demo.aggrid.example.repository.ProductRepository;
import test.java.demo.aggrid.example.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> getProductByDate(String date1, String date2) {
		List<Product> products = productRepository.getProductByDate(date1, date2);
		return products;
	}

	@Override
	public void save(List<Product> products) {
		productRepository.saveAll(products);
		
	}

	@Override
	public void deleteAll() {
		productRepository.deleteAll();
		
	}

}
