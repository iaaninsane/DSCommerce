package com.devsuperior.dscommerce.product;

import lombok.Getter;

@Getter
public class ProductDTO {

	private String name;

	private String description;

	private Double price;

	private String imgUrl;

	public ProductDTO(Product product) {
		
		name = product.getName();
		description = product.getDescription();
		price = product.getPrice();
		imgUrl = product.getImgUrl();		
		
	}	
	
}
