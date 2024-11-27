package com.devsuperior.dscommerce.product;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	private ProductRepository productRepository;
	
	
	
	public ProductController(ProductRepository productRepository) {

		this.productRepository = productRepository;
	}



	@GetMapping
	public String getProductById() {
		
		Optional<Product> result = productRepository.findById(1L);
		Product product = result.get();
		return product.getName();
	}
	

}
