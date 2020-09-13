package com.example.app3.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app3.model.member.MemberVO;
import com.example.app3.model.product.ProductFile;
import com.example.app3.model.product.ProductService;
import com.example.app3.model.product.ProductVO;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("/products")
	public Map addProduct(ProductFile pf) {
		service.addProduct(pf);
		String seller = pf.getP().getSeller().getId();
		System.out.println(pf.getP());
		Map map = new HashMap();
		map.put("action", "add product");
		map.put("result", true);
		return map;
	}

	// @GetMapping("/products/{num}")
	// public Map getProduct(@PathVariable("num") Integer num) {
	// Map map = new HashMap();
	// ProductVO p = service.getByNum(num);
	// map.put("action", "get product");
	// map.put("data", p);
	// return map;
	// }

	@GetMapping("/products/{num}")
	public Map details(@PathVariable("num") int num) {
		String result = "";
		ProductVO p = service.getByNum(num);
		Map map = new HashMap();
		map.put("action", "get product");
		map.put("result", p != null);
		map.put("data", p);
		return map;
	}

	@PutMapping("/products/{num}")
	public Map editProduct(ProductVO p) {
		service.editProduct(p);
		Map map = new HashMap();
		map.put("action", "edit product");
		map.put("result", true);
		return map;
	}

	@DeleteMapping("/products/{num}")
	public Map delProduct(@PathVariable("num") Integer num) {
		Map map = new HashMap();
		ProductVO p = service.getByNum(num);
		map.put("action", "delete product");
		service.delProduct(num);
		return map;
	}

	@GetMapping("/products/items/{name}")
	public Map listByName(@PathVariable("name") String name) {
		Map map = new HashMap();
		List<ProductVO> list = null;
		boolean result = true;
		try {
			list = service.getByName(name);
		} catch (Exception e) {
			System.out.println(list);
			result = false;
		}
		map.put("action", "list by product-name");
		map.put("result", result);
		if (result) {
			map.put("data", list);
		}
		return map;
	}

	// @GetMapping("/products")
	// public Map listAll() {
	// Map map = new HashMap();
	// List<ProductVO> list = null;
	// boolean result = true;
	// try {
	// list = service.getAll();
	// } catch (Exception e) {
	// System.out.println(list);
	// result = false;
	// }
	// map.put("action", "list all");
	// map.put("result", result);
	// if (result) {
	// map.put("data", list);
	// }
	// return map;
	// }

	@GetMapping("/products")
	public Map listall(Model m) {
		List<ProductVO> list = service.getAll();
		Map map = new HashMap();
		map.put("action", "product get");
		map.put("result", true);
		map.put("data", list);
		return map;
	}

	@GetMapping("/products/members/{seller}")
	public Map listBySeller(@PathVariable("seller") String seller) {
		MemberVO m = new MemberVO();
		m.setId(seller);
		boolean result = false;
		Map map = new HashMap();
		map.put("action", "product list by seller");
		if (m != null) {
			result = true;
			List<ProductVO> list = service.getBySeller(m);
			map.put("data", list);
		}
		map.put("result", result);
		return map;
	}
}
