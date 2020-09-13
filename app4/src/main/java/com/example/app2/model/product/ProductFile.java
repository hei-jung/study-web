package com.example.app2.model.product;

import org.springframework.web.multipart.MultipartFile;

public class ProductFile {

	private Product p;
	private MultipartFile f;

	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}

	public MultipartFile getF() {
		return f;
	}

	public void setF(MultipartFile f) {
		this.f = f;
	}

	@Override
	public String toString() {
		return "ProductFile [p=" + p + ", f=" + f + "]";
	}

}
