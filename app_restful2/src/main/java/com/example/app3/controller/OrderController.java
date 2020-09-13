package com.example.app3.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app3.model.member.MemberVO;
import com.example.app3.model.order.MyOrder;
import com.example.app3.model.order.MyOrderService;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {
	@Autowired
	private MyOrderService service;

	@PostMapping("/orders")
	public Map order(MyOrder o) {
		service.addOrder(o);
		Map map = new HashMap();
		map.put("action", "order create");
		map.put("result", true);
		return map;
	}

	@GetMapping("/orders/{con}/{type}")
	public Map myorderlist(@PathVariable("con") String con, @PathVariable("type") Integer type) {
		MemberVO m = new MemberVO();
		m.setId(con);
		boolean result = false;
		Map map = new HashMap();
		map.put("action", "orders by consumer");
		if (m != null) {
			result = true;
			List<MyOrder> list = service.getByConid(m);
			List<MyOrder> list_type = new ArrayList<MyOrder>();
			for (MyOrder o : list) {
				if (o.getTypei() == type) {
					list_type.add(o);
				}
			}
			map.put("data", list_type);
		}
		map.put("result", result);
		return map;
	}
}
