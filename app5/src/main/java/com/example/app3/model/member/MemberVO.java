package com.example.app3.model.member;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.example.app3.model.order.OrderVO;
import com.example.app3.model.product.ProductVO;

@Entity
public class MemberVO {

	@Id
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Integer typei;
	private String types;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "seller", cascade = CascadeType.REMOVE)
	private List<ProductVO> products;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "con", cascade = CascadeType.REMOVE)
	private List<OrderVO> orders;

	public MemberVO() {
	}

	public MemberVO(String id, String pwd, String name, String email, Integer typei, String types) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.typei = typei;
		this.types = types;
	}

	@PrePersist
	public void createTypes() {
		switch (typei) {
		case 0:
			types = "CONSUMER";
			break;
		case 1:
			types = "SELLER";
			break;
		}
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

	public Integer getTypei() {
		return typei;
	}

	public void setTypei(Integer typei) {
		this.typei = typei;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public List<ProductVO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductVO> products) {
		this.products = products;
	}

	public List<OrderVO> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderVO> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", typei=" + typei
				+ ", types=" + types + "]";
	}

}
