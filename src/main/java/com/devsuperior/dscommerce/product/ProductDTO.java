package com.devsuperior.dscommerce.product;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductDTO {

	private  static final String NOME_TAMANHO_MSG = "nome precisa ter entre 3 e 80 caracteres";
	private  static final String DESCRIPTION_TAMANHO_MSG = "descrição precisa ter no mínimo 10 caracteres";
	private  static final String CAMPO_REQUERIDO_MSG = "Campo requerido";
	private  static final String PREC0_POSITIVO_MSG = "O preço deve ser positivo";
	private Long id;

	@Size(min = 3, max = 80, message = NOME_TAMANHO_MSG)
	@NotBlank(message = CAMPO_REQUERIDO_MSG)
	private String name;

	@Size(min = 10, message = DESCRIPTION_TAMANHO_MSG)
	@NotBlank(message = CAMPO_REQUERIDO_MSG)
	private String description;

	@Positive(message = PREC0_POSITIVO_MSG)
	private Double price;

	private String imgUrl;

	public ProductDTO(Product product) {

		id = product.getId();
		name = product.getName();
		description = product.getDescription();
		price = product.getPrice();
		imgUrl = product.getImgUrl();
	}	
	
}
