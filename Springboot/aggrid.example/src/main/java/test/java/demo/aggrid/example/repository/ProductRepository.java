package test.java.demo.aggrid.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import test.java.demo.aggrid.example.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	 @Query(value = "select t from Product t where t.start_date > ?1 AND t.end_date < ?2", nativeQuery = true)
	List<Product> getProductByDate(String date1, String date2);

}