package br.edu.infnet.appvenda.entity;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "customer_order")
public class Customer_Orders implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer order_id;
	
	@ManyToOne
	@JoinColumn(name = "costumer_id")
	private Customer customer;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant date_order_placed;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant date_order_paid;
	private Double der_total_order_price;
	private String other_order_detais;
	
	@OneToMany(mappedBy = "order_id")
	private Set<Customer_Orders_Products> items = new HashSet<>();
	
	public Customer_Orders() {
		
	}

	public Customer_Orders(Integer order_id, Customer customer, Instant date_order_placed, Instant date_order_paid,
			Double der_total_order_price, String other_order_detais) {
		super();
		this.order_id = order_id;
		this.customer = customer;
		this.date_order_placed = date_order_placed;
		this.date_order_paid = date_order_paid;
		this.der_total_order_price = der_total_order_price;
		this.other_order_detais = other_order_detais;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Instant getDate_order_placed() {
		return date_order_placed;
	}

	public void setDate_order_placed(Instant date_order_placed) {
		this.date_order_placed = date_order_placed;
	}

	public Instant getDate_order_paid() {
		return date_order_paid;
	}

	public void setDate_order_paid(Instant date_order_paid) {
		this.date_order_paid = date_order_paid;
	}

	public Double getDer_total_order_price() {
		return der_total_order_price;
	}

	public void setDer_total_order_price(Double der_total_order_price) {
		this.der_total_order_price = der_total_order_price;
	}

	public String getOther_order_detais() {
		return other_order_detais;
	}

	public void setOther_order_detais(String other_order_detais) {
		this.other_order_detais = other_order_detais;
	}

	@Override
	public String toString() {
		return "Customer_Orders [order_id=" + order_id + ", customer=" + customer + ", date_order_placed="
				+ date_order_placed + ", date_order_paid=" + date_order_paid + ", der_total_order_price="
				+ der_total_order_price + ", other_order_detais=" + other_order_detais + "]";
	}
	
	
	
}