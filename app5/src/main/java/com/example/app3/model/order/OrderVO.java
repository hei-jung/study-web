package com.example.app3.model.order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;

import com.example.app3.model.member.MemberVO;
import com.example.app3.model.product.ProductVO;

@Entity
public class OrderVO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_order_sequence")
	@SequenceGenerator(name = "my_order_sequence", sequenceName = "seq_my_order")
	private Integer num;

	@ManyToOne
	@JoinColumn(name = "pnum", nullable = false)
	private ProductVO pnum;

	private Integer amount;
	private Integer total_price;
	private Integer typei;
	private String types;

	@ManyToOne
	@JoinColumn(name = "con", nullable = false)
	private MemberVO con;

	public OrderVO() {
	}

	public OrderVO(Integer num, ProductVO pnum, Integer amount, Integer total_price, Integer typei, String types,
			MemberVO con) {
		this.num = num;
		this.pnum = pnum;
		this.amount = amount;
		this.total_price = total_price;
		this.typei = typei;
		this.types = types;
		this.con = con;
	}

	@PrePersist
	public void createTypes() {
		switch (typei) {
		case 0:
			types = "PAY";
			break;
		case 1:
			types = "CART";
			break;
		}
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public ProductVO getPnum() {
		return pnum;
	}

	public void setPnum(ProductVO pnum) {
		this.pnum = pnum;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getTotal_price() {
		return total_price;
	}

	public void setTotal_price(Integer total_price) {
		this.total_price = total_price;
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

	public MemberVO getCon() {
		return con;
	}

	public void setCon_id(MemberVO con) {
		this.con = con;
	}

	@Override
	public String toString() {
		return "OrderVO [num=" + num + ", pnum=" + pnum + ", amount=" + amount + ", total_price=" + total_price
				+ ", typei=" + typei + ", types=" + types + "]";
	}

}