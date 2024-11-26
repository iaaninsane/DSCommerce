package com.devsuperior.dscommerce.orderitem;

import java.math.BigDecimal;

import com.devsuperior.dscommerce.order.Order;
import com.devsuperior.dscommerce.product.Product;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_order_item")
@NoArgsConstructor
public class OrderItem {

	@EmbeddedId
	private OrderItemPK id = new OrderItemPK();

	private Integer quantity;

	private BigDecimal price;

	public OrderItem(Order order, Product product, Integer quantity, BigDecimal price) {

		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}

	public Order getOrder() {
		return id.getOrder();
	}

	public void setOrder(Order order) {
		id.setOrder(order);
	}

	public Product getProduct() {
		return id.getProduct();
	}

	public void setProduct(Product product) {

		id.setProduct(product);
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
