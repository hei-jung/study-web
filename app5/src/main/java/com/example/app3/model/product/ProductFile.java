package com.example.app3.model.product;

import org.springframework.web.multipart.MultipartFile;

public class ProductFile {

	private ProductVO p;
	private MultipartFile f;

	public ProductVO getP() {
		return p;
	}

	public void setP(ProductVO p) {
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
