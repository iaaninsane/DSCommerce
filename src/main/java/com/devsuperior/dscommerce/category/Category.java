package com.devsuperior.dscommerce.category;

import java.util.HashSet;
import java.util.Set;

import com.devsuperior.dscommerce.product.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_category")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;

	@ManyToMany(mappedBy = "categories")
	private Set<Product> products = new HashSet<>();
}
