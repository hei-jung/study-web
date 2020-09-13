package com.example.app2.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app2.model.order.MyOrder;
import com.example.app2.model.order.MyOrderService;
import com.example.app2.model.order.OrderType;
import com.example.app2.model.product.Product;
import com.example.app2.model.product.ProductService;

@Controller
public class OrderController {

	@Autowired
	private MyOrderService service;
	@Autowired
	private ProductService p_service;

	@PostMapping("/order")
	public String add(MyOrder o) {
		o.setTotal_price(o.getAmount() * o.getTotal_price());
		service.updateOrder(o);
		String con_id = o.getCon_id().getId();
		if (o.getType().equals(OrderType.PAY)) {
			Product p = o.getPnum();
			int amt = p.getAmount();
			p.setAmount(amt - o.getAmount());
			p_service.editProduct(p);
		}
		return "redirect:/order/myorder/" + con_id;
	}

	@GetMapping("/order/delete/{num}")
	public String del(@PathVariable("num") int num, HttpServletRequest req) {
		service.delOrder(num);
		HttpSession session = req.getSession(false);
		String con_id = (String) session.getAttribute("id");
		return "redirect:/order/myorder/" + con_id;
	}

	@GetMapping("/order/edit/{num}")
	public String editForm(@PathVariable("num") int num, Model m) {
		MyOrder o = service.getByNum(num);
		m.addAttribute("o", o);
		return "order/editForm";
	}

	@PostMapping("/order/edit")
	public String edit(MyOrder o) {
		String page = add(o);
		return page;
	}

}
