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
import com.example.app3.model.product.Product;
import com.example.app3.model.product.ProductFile;
import com.example.app3.model.product.ProductService;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {
	@Autowired
	private ProductService service;

	@PostMapping("/products")
	public Map add(ProductFile pf) {
		System.out.println(pf);
		service.addProduct(pf);
		String seller = pf.getP().getSeller().getId();
		System.out.println(pf.getP());
		Map map = new HashMap();
		map.put("action", "product create");
		map.put("result", true);
		return map;
	}

	@GetMapping("/products/{num}")
	public Map details(@PathVariable("num") int num) {
		String result = "";
		Product p = service.getByNum(num);
		Map map = new HashMap();
		map.put("action", "product get");
		map.put("result", p != null);
		map.put("data", p);
		return map;
	}

	@GetMapping("/products")
	public Map listall(Model m) {
		List<Product> list = service.getAll();
		Map map = new HashMap();
		map.put("action", "product get");
		map.put("result", true);
		map.put("data", list);
		return map;
	}

	@GetMapping("/products/items/{name}")
	public Map listbyname(@PathVariable("name") String name) {
		List<Product> list = service.getByName("%" + name + "%");
		Map map = new HashMap();
		map.put("action", "product get");
		map.put("result", true);
		map.put("data", list);
		return map;
	}

	@PutMapping("/products/")
	public Map edit(Product p) {
		service.editProduct(p);
		Map map = new HashMap();
		map.put("action", "product edit");
		map.put("result", true);
		return map;
	}

	@DeleteMapping("/products/{num}")
	public Map del(@PathVariable("num") int num) {
		service.delProduct(num);
		Map map = new HashMap();
		map.put("action", "product edit");
		map.put("result", true);
		return map;
	}

	@GetMapping("/products/itemsby/{seller}")
	public Map listbyseller(@PathVariable("seller") String seller) {
		MemberVO m = new MemberVO();
		m.setId(seller);
		boolean result = false;
		Map map = new HashMap();
		map.put("action", "product getby seller");
		if (m != null) {
			result = true;
			List<Product> list = service.getBySeller(m);
			map.put("data", list);
		}
		map.put("result", result);
		return map;
	}
}
