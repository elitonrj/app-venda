package br.edu.infnet.appvenda.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Products implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer product_id;
	private Double product_price;
	private String book_isbn;
	private String book_author;
	private String book_publication_date;
	private String book_title;
	private String food_contains_yn;
	private String food_name;
	private String food_description;
	private String food_flavor;
	private String food_ingredients;
	private String ohter_product_details;
	
	@OneToMany (mappedBy = "order_id")
	private Set<Customer_Orders_Products> items = new HashSet<>();
	
	public Products() {
		
	}

	public Products(Integer product_id, Double product_price, String book_isbn, String book_author,
			String book_publication_date, String book_title, String food_contains_yn, String food_name,
			String food_description, String food_flavor, String food_ingredients, String ohter_product_details) {
		super();
		this.product_id = product_id;
		this.product_price = product_price;
		this.book_isbn = book_isbn;
		this.book_author = book_author;
		this.book_publication_date = book_publication_date;
		this.book_title = book_title;
		this.food_contains_yn = food_contains_yn;
		this.food_name = food_name;
		this.food_description = food_description;
		this.food_flavor = food_flavor;
		this.food_ingredients = food_ingredients;
		this.ohter_product_details = ohter_product_details;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public Double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(Double product_price) {
		this.product_price = product_price;
	}

	public String getBook_isbn() {
		return book_isbn;
	}

	public void setBook_isbn(String book_isbn) {
		this.book_isbn = book_isbn;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public String getBook_publication_date() {
		return book_publication_date;
	}

	public void setBook_publication_date(String book_publication_date) {
		this.book_publication_date = book_publication_date;
	}

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public String getFood_contains_yn() {
		return food_contains_yn;
	}

	public void setFood_contains_yn(String food_contains_yn) {
		this.food_contains_yn = food_contains_yn;
	}

	public String getFood_name() {
		return food_name;
	}

	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}

	public String getFood_description() {
		return food_description;
	}

	public void setFood_description(String food_description) {
		this.food_description = food_description;
	}

	public String getFood_flavor() {
		return food_flavor;
	}

	public void setFood_flavor(String food_flavor) {
		this.food_flavor = food_flavor;
	}

	public String getFood_ingredients() {
		return food_ingredients;
	}

	public void setFood_ingredients(String food_ingredients) {
		this.food_ingredients = food_ingredients;
	}

	public String getOhter_product_details() {
		return ohter_product_details;
	}

	public void setOhter_product_details(String ohter_product_details) {
		this.ohter_product_details = ohter_product_details;
	}

	@Override
	public String toString() {
		return "Products [product_id=" + product_id + ", product_price=" + product_price + ", book_isbn=" + book_isbn
				+ ", book_author=" + book_author + ", book_publication_date=" + book_publication_date + ", book_title="
				+ book_title + ", food_contains_yn=" + food_contains_yn + ", food_name=" + food_name
				+ ", food_description=" + food_description + ", food_flavor=" + food_flavor + ", food_ingredients="
				+ food_ingredients + ", ohter_product_details=" + ohter_product_details + "]";
	}
	
	
	
}