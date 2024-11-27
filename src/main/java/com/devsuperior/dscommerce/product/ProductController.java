package com.devsuperior.dscommerce.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		
		this.productService = productService;
	}

	@GetMapping("/{id}")
	public ProductDTO getProductById(@PathVariable Long id) {
		
		return productService.findProduct(id);
	}
	
}
