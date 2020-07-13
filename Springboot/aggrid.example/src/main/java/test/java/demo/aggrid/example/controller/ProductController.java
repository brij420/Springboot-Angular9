package test.java.demo.aggrid.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import test.java.demo.aggrid.example.exception.ResourceNotFoundException;
import test.java.demo.aggrid.example.model.Product;
import test.java.demo.aggrid.example.repository.ProductRepository;
import test.java.demo.aggrid.example.service.ProductService;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public List<Product> getAllProduct() {
		return productService.getAllProduct();
	}

	@GetMapping("/productsFilter")
	public List<Product> getProductByDate(@RequestParam String date1
            , @RequestParam String date2)
			throws ResourceNotFoundException {
		List<Product> products = productService.getProductByDate(date1,date2);
		return products;
	}


}