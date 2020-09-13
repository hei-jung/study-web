package com.example.app2.model.product;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository rep;
	private String path = "C:\\Users\\Playdata\\Desktop\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\img\\";

	// 제품추가
	public void addProduct(ProductFile pf) {
		Product p = rep.save(pf.getP());
		String fname = pf.getF().getOriginalFilename();
		String f_end = fname.substring(fname.lastIndexOf("."));// 확장자 잘라내기
		String name = p.getNum() + f_end;
		File f = new File(path + name);
		try {
			pf.getF().transferTo(f);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.setImg("/img/" + name);
		editProduct(p);
		System.out.println(p);
	}

	// 제품정보 수정
	public void editProduct(Product p) {
		rep.save(p);
	}

	// 제품삭제
	public void delProduct(Integer num) {
		rep.deleteById(num);
	}

	// 제품번호로 검색
	public Product getByNum(Integer num) {
		return rep.getOne(num);
	}

	// 제품명으로 검색(like)
	public List<Product> getByName(String name) {
		return rep.findByNameLike("%" + name + "%");
	}

	// 제품seller별 검색: Shop_Member 쪽에서

	// 제품전체목록
	public List<Product> getAll() {
		return rep.findAll();
	}
}