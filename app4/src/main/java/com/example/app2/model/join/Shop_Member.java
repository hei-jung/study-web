package com.example.app2.model.join;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.app2.model.order.MyOrder;
import com.example.app2.model.product.Product;

@Entity
public class Shop_Member {
	
	@Id
	private String id;
	private String pwd;
	private String name;
	private String email;

	@Enumerated(EnumType.STRING)
	private MemberType type;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "seller", cascade = CascadeType.REMOVE)
	private List<Product> products;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "con_id", cascade = CascadeType.REMOVE)
	private List<MyOrder> orders;

	public Shop_Member() {
	}

	public Shop_Member(String id, String pwd, String name, String email, MemberType type) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MemberType getType() {
		return type;
	}

	public void setType(MemberType type) {
		this.type = type;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<MyOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<MyOrder> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Shop_Member [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", type=" + type
				+ "]";
	}

}
