package com.streamlineideas.ecommerce;

import com.streamlineideas.ecommerce.entity.Product;
import com.streamlineideas.ecommerce.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class EcommerceApplication {

	@Autowired
	private ProductRepository productRepository;

	@PostConstruct
	public void initTable() {
//		List<Product> products = Stream.of(
//				new Product("Laptop", "Electronics", 74999.99, 50),
//				new Product("Smartphone", "Electronics", 39999.99, 100),
//				new Product("Office Chair", "Furniture", 7999.99, 200),
//				new Product("Notebook", "Stationery", 99.99, 500),
//				new Product("Desk Lamp", "Furniture", 1999.99, 150),
//				new Product("Water Bottle", "Accessories", 499.99, 300)
//		).collect(Collectors.toList());
//		productRepository.saveAll(products);
	}

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

}
