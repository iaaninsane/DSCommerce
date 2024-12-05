package com.devsuperior.dscommerce.product;

import java.net.URI;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/products")
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService productService) {

		this.productService = productService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {

		return ResponseEntity.ok(productService.findProduct(id));
	}

	@GetMapping
	public ResponseEntity<Page<ProductDTO>> getProductById(Pageable pag) {

		return ResponseEntity.ok(productService.findAllProduct(pag));
	}

	@PostMapping
	public ResponseEntity<ProductDTO> insertProduct(@Valid @RequestBody ProductDTO productDTO) {

		productDTO = productService.saveProduct(productDTO);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(productDTO.getId())
				.toUri();

		return ResponseEntity.created(uri).body(productDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductDTO> renewProduct(@PathVariable Long id, @Valid @RequestBody ProductDTO productDTO) {

		productDTO = productService.updateProduct(id, productDTO);

		return ResponseEntity.ok(productDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excludeProduct(@PathVariable Long id) {

		productService.deleteProduct(id);

		return ResponseEntity.noContent().build();
	}

}
