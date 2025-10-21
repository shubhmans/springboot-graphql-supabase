package com.streamlineideas.ecommerce.repository;

import com.streamlineideas.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByCategory(String category);

    // Find products whose price is between minPrice and maxPrice (inclusive)
    List<Product> findByPriceBetween(double minPrice, double maxPrice);
}
