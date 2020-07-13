package test.java.demo.aggrid.example;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.BeanDefinitionDsl.BeanSupplierContext;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.sun.el.parser.ParseException;

import test.java.demo.aggrid.example.service.ProductService;
import test.java.demo.aggrid.example.model.Product;

@SpringBootApplication
public class Application {
public static final String DATE_FORMATE="yyyy-MM-dd HH:mm:ss";
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	CommandLineRunner runner(ProductService productService) {
		productService.deleteAll();
		return args -> {
			// read json and write to db

			ObjectMapper mapper = new ObjectMapper();
			List<Product> listOfEntity=new ArrayList<Product>();
			InputStream inputStream = TypeReference.class.getResourceAsStream("/data.json");
			try {
				List<Object> products = mapper.readValue(inputStream,List.class);
				for(Object product:products) {
					if(product!=null) {
						ObjectMapper m = new ObjectMapper();
						LinkedHashMap<Object,Object> map = m.convertValue(product, LinkedHashMap.class);
						
						Product entity=new Product();
						entity.setId(Long.parseLong(map.get("id").toString()));
						entity.setCity((String) map.get("city"));
						entity.setColor((String) map.get("color"));
						entity.setEnd_date((String) map.get("end_date"));
						entity.setPrice((String) map.get("price"));
						entity.setStart_date((String) map.get("start_date"));
						entity.setStatus((String) map.get("status"));
						BeanUtils.copyProperties(product, entity);
						listOfEntity.add(entity);
					}
				}
				
				productService.save(listOfEntity);
				System.out.println("Product Saved!");
			} catch (IOException e){
				System.out.println("Unable to save Product: " + e.getMessage());
			}
		};
	}
	
	protected String dateToString(Date date,String format) {
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		return sdf.format(date);
		
	}
	
	protected Date getSystemDate() {
		Calendar cal= Calendar.getInstance();
		return cal.getTime();
	}
	
	protected Date stringToDate(String dateStr,String format) {
		DateFormat sdf=new SimpleDateFormat(format);
		Date date=null;
		try {
			date=sdf.parse(dateStr);
		} catch (java.text.ParseException e) {
			System.out.println(e.getMessage());
		}
		return date;
	}

}
