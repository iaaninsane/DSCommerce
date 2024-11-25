package com.devsuperior.dscommerce.user;

import java.time.LocalDate;
import java.util.List;

import com.devsuperior.dscommerce.order.Order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private String phone;
	
	@Column(name = "birth_date")
	private LocalDate birthDate;
	
	@Column
	private String password;
	
	@OneToMany(mappedBy = "user")
	private List<Order> orders;
	
}