package com.devsuperior.dscommerce.product;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	@Transactional(readOnly = true)
	public Page<ProductDTO> findAllProduct(Pageable pag) {

		Page<Product> result = productRepository.findAll(pag);
		
		return result.map(pr -> new ProductDTO(pr));
	}
	
	@Transactional
	public ProductDTO saveProduct(ProductDTO productDTO) {

		Product entityProduct = Product.builder()
				.name(productDTO.getName())
				.description(productDTO.getDescription())
				.price(productDTO.getPrice())
				.imgUrl(productDTO.getImgUrl())
				.build();
		
		entityProduct = productRepository.save(entityProduct);
		return new ProductDTO(entityProduct);
	}
	
	@Transactional
	public ProductDTO updateProduct(Long id, ProductDTO productDTO) {

		Product entityProduct = productRepository.getReferenceById(id);
		
		entityProduct.setName(productDTO.getName());
		entityProduct.setDescription(productDTO.getDescription());
		entityProduct.setPrice(productDTO.getPrice());
		entityProduct.setImgUrl(productDTO.getImgUrl());	
		
		entityProduct = productRepository.save(entityProduct);
		return new ProductDTO(entityProduct);
	}
	
	@Transactional
	public void deleteProduct(Long id) {

		 productRepository.deleteById(id);
	
	}

}
