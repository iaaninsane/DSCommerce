package com.devsuperior.dscommerce.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	@GetMapping
	public Page<ProductDTO> getProductById(Pageable pag) {
		
		return productService.findAllProduct(pag);
	}
	
}
