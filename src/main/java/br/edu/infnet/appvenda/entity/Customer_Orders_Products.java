package br.edu.infnet.appvenda.entity;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "customer_orders_products")
public class Customer_Orders_Products {

    private Products products;
    private Customer_Orders customer_orders;
	
	private Integer quantity;
	private String comments;
	
	public Customer_Orders_Products() {
		
	}

	public Customer_Orders_Products(Products products, Customer_Orders customer_orders, Integer quantity,
			String comments) {
		super();
		this.products = products;
		this.customer_orders = customer_orders;
		this.quantity = quantity;
		this.comments = comments;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public Customer_Orders getCustomer_orders() {
		return customer_orders;
	}

	public void setCustomer_orders(Customer_Orders customer_orders) {
		this.customer_orders = customer_orders;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	
}