package com.devsuperior.dscommerce.product;

import com.devsuperior.dscommerce.shared.exception.DataBaseException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscommerce.shared.exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

    private final static String RESOURCE_NOT_FOUND_MSG = "Recurso não encontrado";
    private final static String DATABASE_EXCEPTION_INTEGRITY_MSG = "Falha na integridade referencial";

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public ProductDTO findProduct(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(RESOURCE_NOT_FOUND_MSG));

        return new ProductDTO(product);
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAllProduct(Pageable pag) {

        Page<Product> result = productRepository.findAll(pag);

        return result.map(pr -> new ProductDTO(pr));
    }

    @Transactional
    public ProductDTO saveProduct(ProductDTO productDTO) {

        Product entityProduct = Product.builder().name(productDTO.getName()).description(productDTO.getDescription())
                .price(productDTO.getPrice()).imgUrl(productDTO.getImgUrl()).build();

        entityProduct = productRepository.save(entityProduct);
        return new ProductDTO(entityProduct);
    }

    @Transactional
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {

        try {

            Product entityProduct = productRepository.getReferenceById(id);

            entityProduct.setName(productDTO.getName());
            entityProduct.setDescription(productDTO.getDescription());
            entityProduct.setPrice(productDTO.getPrice());
            entityProduct.setImgUrl(productDTO.getImgUrl());

            entityProduct = productRepository.save(entityProduct);
            return new ProductDTO(entityProduct);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(RESOURCE_NOT_FOUND_MSG);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteProduct(Long id) {

        try {
            if (!productRepository.existsById(id)) {
                throw new ResourceNotFoundException(RESOURCE_NOT_FOUND_MSG);
            }
            productRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(DATABASE_EXCEPTION_INTEGRITY_MSG);
        }



    }

}
