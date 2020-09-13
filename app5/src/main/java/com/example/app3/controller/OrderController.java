package com.example.app3.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app3.model.member.MemberVO;
import com.example.app3.model.order.OrderService;
import com.example.app3.model.order.OrderVO;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {

	@Autowired
	private OrderService service;

	@PostMapping("/myorder")
	public Map addOrder(OrderVO o) {
		Map map = new HashMap();
		OrderVO o2 = service.updateOrder(o);
		map.put("action", "add order");
		map.put("result", o2 != null);
		map.put("data", o2);
		return map;
	}

	@GetMapping("/myorder/{num}")
	public Map getOrder(@PathVariable("num") Integer num) {
		Map map = new HashMap();
		OrderVO o = service.getByNum(num);
		map.put("action", "get order");
		map.put("data", o);
		return map;
	}

	@PutMapping("/myorder/{num}")
	public Map editOrder(@PathVariable("num") Integer num, OrderVO o) {
		Map map = new HashMap();
		OrderVO o2 = service.getByNum(num);
		map.put("action", "update order");
		o2.setAmount(o.getAmount());
		o2.setTotal_price(o.getTotal_price());
		o2.setTypei(o.getTypei());
		o2.setTypes(o.getTypes());
		OrderVO o3 = service.updateOrder(o2);
		map.put("data", o3);
		return map;
	}

	@DeleteMapping("/myorder/{num}")
	public Map delOrder(@PathVariable("num") Integer num) {
		Map map = new HashMap();
		OrderVO o = service.getByNum(num);
		map.put("action", "delete order");
		service.delOrder(num);
		return map;
	}

	@GetMapping("/myorder/ordertype/{type}")
	public Map listByType(@PathVariable("type") int type) {
		Map map = new HashMap();
		List<OrderVO> list = null;
		boolean result = true;
		try {
			list = service.getByType(type);
		} catch (Exception e) {
			System.out.println(list);
			result = false;
		}
		map.put("action", "list by order-type");
		map.put("result", result);
		if (result) {
			map.put("data", list);
		}
		return map;
	}

	@GetMapping("/orders/{con}/{type}")
	public Map myorderlist(@PathVariable("con") String con, @PathVariable("type") int type) {
		MemberVO m = new MemberVO();
		m.setId(con);
		boolean result = false;
		Map map = new HashMap();
		map.put("action", "orders by consumer");
		if (m != null) {
			result = true;
			List<OrderVO> list = service.getByCon_id(m);
			List<OrderVO> list_type = new ArrayList<OrderVO>();
			for (OrderVO o : list) {
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
