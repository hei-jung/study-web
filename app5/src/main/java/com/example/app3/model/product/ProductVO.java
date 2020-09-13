package com.example.app3.model.product;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.example.app3.model.member.MemberVO;
import com.example.app3.model.order.OrderVO;

@Entity
public class ProductVO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
	@SequenceGenerator(name = "product_sequence", sequenceName = "seq_product")
	private Integer num;

	private String name;
	private Integer price;
	private Integer amount;
	private String info;
	private String img;

	@ManyToOne
	@JoinColumn(name = "seller", nullable = false)
	private MemberVO seller;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pnum", cascade = CascadeType.REMOVE)
	private List<OrderVO> orders;

	public ProductVO() {
	}

	public ProductVO(Integer num, String name, Integer price, Integer amount, String info, String img,
			MemberVO seller) {
		this.num = num;
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.info = info;
		this.img = img;
		this.seller = seller;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public MemberVO getSeller() {
		return seller;
	}

	public void setSeller(MemberVO seller) {
		this.seller = seller;
	}

	public List<OrderVO> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderVO> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "ProductVO [num=" + num + ", name=" + name + ", price=" + price + ", amount=" + amount + ", info=" + info
				+ ", img=" + img + ", seller=" + seller + "]";
	}

}
