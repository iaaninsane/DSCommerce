package com.devsuperior.dscommerce.order;

import java.time.Instant;

import com.devsuperior.dscommerce.enums.OrderStatus;
import com.devsuperior.dscommerce.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_order")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Instant moment;
	
	@Column
	private OrderStatus status;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;
}
