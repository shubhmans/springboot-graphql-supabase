package com.streamlineideas.ecommerce.service;

import com.streamlineideas.ecommerce.entity.Product;
import com.streamlineideas.ecommerce.repository.ProductRepository;
import com.streamlineideas.ecommerce.exception.InvalidPriceRangeException;
import com.streamlineideas.ecommerce.dto.ErrorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    // Return products whose price is between minPrice and maxPrice.
    // If minPrice > maxPrice we throw a custom runtime exception with an ErrorDTO.
    public List<Product> getProductsByPriceRange(double minPrice, double maxPrice) {
        if (minPrice > maxPrice) {
            ErrorDTO error = new ErrorDTO("INVALID_PRICE_RANGE", "minPrice must be less than or equal to maxPrice");
            throw new InvalidPriceRangeException(error);
        }
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }
}
