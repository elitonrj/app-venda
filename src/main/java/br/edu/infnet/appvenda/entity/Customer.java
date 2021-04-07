package br.edu.infnet.appvenda.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer costumer_id;
	private String first_name;
	private String middle_name;
	private String last_name;
	private String costumer_phone;
	private String costumer_email;
	private String other_costumer_details;
	
	@OneToMany(mappedBy = "order_id")
	private List<Customer_Orders> orders = new ArrayList<>();
	
	public Customer() {
		
	}

	public Customer(Integer costumer_id, String first_name, String middle_name, String last_name, String costumer_phone,
			String costumer_email, String other_costumer_details) {
		super();
		this.costumer_id = costumer_id;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.costumer_phone = costumer_phone;
		this.costumer_email = costumer_email;
		this.other_costumer_details = other_costumer_details;
	}

	public Integer getCostumer_id() {
		return costumer_id;
	}

	public void setCostumer_id(Integer costumer_id) {
		this.costumer_id = costumer_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getCostumer_phone() {
		return costumer_phone;
	}

	public void setCostumer_phone(String costumer_phone) {
		this.costumer_phone = costumer_phone;
	}

	public String getCostumer_email() {
		return costumer_email;
	}

	public void setCostumer_email(String costumer_email) {
		this.costumer_email = costumer_email;
	}

	public String getOther_costumer_details() {
		return other_costumer_details;
	}

	public void setOther_costumer_details(String other_costumer_details) {
		this.other_costumer_details = other_costumer_details;
	}

	@Override
	public String toString() {
		return "Costumer [costumer_id=" + costumer_id + ", first_name=" + first_name + ", middle_name=" + middle_name
				+ ", last_name=" + last_name + ", costumer_phone=" + costumer_phone + ", costumer_email="
				+ costumer_email + ", other_costumer_details=" + other_costumer_details + "]";
	}
	
	
}