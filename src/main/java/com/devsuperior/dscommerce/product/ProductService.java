package com.devsuperior.dscommerce.product;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

	private ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {

		this.productRepository = productRepository;
	}

	@Transactional(readOnly = true)
	public ProductDTO findProduct(Long id) {

		Optional<Product> result = productRepository.findById(id);
		Product product = result.get();
		ProductDTO dto = new ProductDTO(product);
		return dto;
	}

}
