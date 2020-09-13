package com.example.app2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app2.model.product.Product;
import com.example.app2.model.product.ProductFile;
import com.example.app2.model.product.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping("/product")
	public String form() {
		return "product/form";
	}

	@PostMapping("/product")
	public String add(ProductFile f) {
		service.addProduct(f);
		String seller = f.getP().getSeller().getId();
		return "redirect:/product/listbyseller/" + seller;
	}

	@GetMapping("/product/details/{num}")
	public String details(@PathVariable("num") int num, Model m) {
		Product p = service.getByNum(num);
		m.addAttribute("p", p);
		return "product/details";
	}

	// @GetMapping("/order/prod_list")
	// public String listall(Model m){
	// List<Product> list = service.getAll();
	// m.addAttribute("list", list);
	// return "order/prod_list";
	// }

	@PostMapping("/product/list/{name}")
	public String listbyname(@PathVariable("name") String name, Model m) {
		List<Product> list = service.getByName(name);
		m.addAttribute("list", list);
		return "redirect:/product/all";
	}

	@PostMapping("/product/edit")
	public String edit(Product p) {
		service.editProduct(p);
		return "redirect:/product/listbyseller/" + p.getSeller().getId();
	}

	@PostMapping("/product/delete")
	public String del(@RequestParam("num") int num) {
		String seller = service.getByNum(num).getSeller().getId();
		service.delProduct(num);
		return "redirect:/product/listbyseller/" + seller;
	}

	@GetMapping("/order/{num}")
	public String form(@PathVariable("num") int num, Model m) {
		Product p = service.getByNum(num);
		m.addAttribute("p", p);
		return "order/form";
	}

	@GetMapping("/product/list/")
	public String listByProductName(@RequestParam("searchby") String searchby, @RequestParam("name") String name,
			Model m) {
		List<Product> list = service.getByName(name);
		m.addAttribute("list", list);
		return "redirect:/product/all";
	}
}
