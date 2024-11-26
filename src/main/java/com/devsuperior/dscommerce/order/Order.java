package com.devsuperior.dscommerce.order;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.devsuperior.dscommerce.enums.OrderStatus;
import com.devsuperior.dscommerce.orderitem.OrderItem;
import com.devsuperior.dscommerce.payment.Payment;
import com.devsuperior.dscommerce.product.Product;
import com.devsuperior.dscommerce.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant moment;
	
	@Column
	private OrderStatus status;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment;
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();
	
	public List<Product> getProducts(){
		return items.stream().map(x -> x.getProduct()).toList();
	}
}
