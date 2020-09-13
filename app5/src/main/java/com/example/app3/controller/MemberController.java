package com.example.app3.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app3.model.member.MemberService;
import com.example.app3.model.member.MemberVO;
import com.example.app3.model.order.OrderVO;
import com.example.app3.model.product.ProductVO;

@RestController
@CrossOrigin(origins = "*") // "http://localhost:7878"
public class MemberController {

	@Autowired
	private MemberService service;

	// 가입, 로그인(인증), 내정보, 수정, 삭제, 타입별 검색

	@PostMapping("/members")
	public Map addMember(MemberVO m) {
		Map map = new HashMap();
		MemberVO m2 = service.save(m);
		map.put("action", "create");
		map.put("result", m2 != null);
		map.put("data", m2);
		return map;
	}

	@GetMapping("/members")
	public Map checkId(MemberVO m) {
		Map map = new HashMap();
		MemberVO m2 = service.getById(m.getId());
		boolean result = false;
		try {
			if (m2.getPwd().equals(m.getPwd())) {
				result = true;
			}
		} catch (EntityNotFoundException e) {
			System.out.println("일치하는 아이디가 없음");
		}
		map.put("action", "login");
		map.put("result", result);
		if (result) {
			map.put("typei", m2.getTypei());
			map.put("types", m2.getTypes());
		}
		return map;
	}

	@GetMapping("/members/{id}")
	public Map getMember(@PathVariable("id") String id) {
		// res.addHeader("Access-Control-Allow-Origin", "*");
		Map map = new HashMap();
		MemberVO m = service.getById(id);
		boolean result = false;
		try {
			m.getPwd();
			result = true;
		} catch (EntityNotFoundException e) {
			System.out.println("일치하는 아이디가 없음");
		}
		map.put("action", "get member");
		map.put("result", result);
		if (result) {
			map.put("data", m);
		}
		return map;
	}

	@PutMapping("/members/{id}")
	public Map editMember(@PathVariable("id") String id, MemberVO m) {
		Map map = new HashMap();
		MemberVO m2 = service.getById(id);
		boolean result = false;
		try {
			m2.getPwd();
			result = true;
		} catch (EntityNotFoundException e) {
			System.out.println("일치하는 아이디가 없음");
		}
		map.put("action", "update member");
		map.put("result", result);
		if (result) {
			m2.setPwd(m.getPwd());
			m2.setEmail(m.getEmail());
			MemberVO m3 = service.save(m2);
			map.put("data", m3);
		}
		return map;
	}

	@DeleteMapping("/members/{id}")
	public Map delMember(@PathVariable("id") String id) {
		Map map = new HashMap();
		MemberVO m = service.getById(id);
		boolean result = false;
		try {
			m.getPwd();
			result = true;
		} catch (EntityNotFoundException e) {
			System.out.println("일치하는 아이디가 없음");
		}
		map.put("action", "delete member");
		map.put("result", result);
		if (result) {
			service.delById(id);
		}
		return map;
	}

	@GetMapping("/members/memtypes/{type}")
	public Map listByType(@PathVariable("type") int type) {
		Map map = new HashMap();
		List<MemberVO> list = null;
		boolean result = true;
		try {
			list = service.getByMemType(type);
		} catch (Exception e) {
			System.out.println(list);
			result = false;
		}
		map.put("action", "list by member-type");
		map.put("result", result);
		if (result) {
			map.put("data", list);
		}
		return map;
	}

	// @GetMapping("/myorder/members/{con_id}")
	// public Map listByCon_id(@PathVariable("con_id") String con_id) {
	// Map map = new HashMap();
	// MemberVO member = service.getById(con_id);
	// List<OrderVO> list = null;
	// boolean result = true;
	// try {
	// list = member.getOrders();
	// } catch (Exception e) {
	// System.out.println(list);
	// result = false;
	// }
	// map.put("action", "order list by con_id");
	// map.put("result", result);
	// if (result) {
	// map.put("data", list);
	// }
	// return map;
	// }

}
