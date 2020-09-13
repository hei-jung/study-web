package com.example.app3.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;

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

@RestController
@CrossOrigin(origins = "*") // @CrossOrigin(origins = "http://localhost:7878")
public class MemberController {
	@Autowired
	private MemberService service;

	// 가입, 인증, 내정보, 수정, 삭제, 타입별 검색

	@PostMapping("/members")
	public Map addMember(MemberVO m) {
		System.out.println(m);
		Map map = new HashMap();
		MemberVO m2 = service.save(m);
		map.put("action", "create");
		map.put("result", m2 != null);
		map.put("data", m2);
		return map;
	}

	@GetMapping("/members")
	public Map checkId(MemberVO m) {
		Map model = new HashMap();
		MemberVO m2 = service.getById(m.getId());
		boolean result = false;
		try {
			if (m2.getPwd().equals(m.getPwd())) {
				result = true;
			}
		} catch (EntityNotFoundException e) {
			System.out.println("아이디 불일치");
		}
		model.put("action", "login");
		model.put("result", result);
		if (result) {
			model.put("typei", m2.getTypei());
			model.put("types", m2.getTypes());
		}
		return model;
	}

	@GetMapping("/members/{id}")
	public Map getMember(@PathVariable("id") String id, HttpServletResponse res) {
		// res.addHeader("Access-Control-Allow-Origin", "*");
		Map model = new HashMap();
		MemberVO m = service.getById(id);
		boolean result = false;
		try {
			m.getPwd();
			result = true;
		} catch (EntityNotFoundException e) {
			System.out.println("아이디 불일치");
		}
		model.put("action", "get member");
		model.put("result", result);
		if (result) {
			System.out.println(m);
			model.put("data", m);
		}
		return model;
	}

	@PutMapping("/members/{id}")
	public Map editMember(@PathVariable("id") String id, MemberVO m) {
		Map model = new HashMap();
		MemberVO m2 = service.getById(id);
		boolean result = false;
		try {
			m2.getPwd();
			result = true;
		} catch (EntityNotFoundException e) {
			System.out.println("아이디 불일치");
		}
		model.put("action", "update member");
		model.put("result", result);
		if (result) {
			m2.setPwd(m.getPwd());
			m2.setEmail(m.getEmail());
			MemberVO m3 = service.save(m2);
			model.put("data", m3);
		}
		return model;
	}

	@DeleteMapping("/members/{id}")
	public Map delMember(@PathVariable("id") String id) {
		Map model = new HashMap();
		MemberVO m2 = service.getById(id);
		boolean result = false;
		try {
			m2.getPwd();
			result = true;
		} catch (EntityNotFoundException e) {
			System.out.println("아이디 불일치");
		}
		model.put("action", "delete member");
		model.put("result", result);
		if (result) {
			service.delById(id);
		}
		return model;
	}

	@GetMapping("/members/memtypes/{type}")
	public Map listbytype(@PathVariable("type") int type) {
		Map model = new HashMap();
		List<MemberVO> list = null;
		boolean result = true;
		try {
			list = service.getByMemType(type);
		} catch (Exception e) {
			System.out.println(list);
			result = false;
		}
		model.put("action", "list by member-type");
		model.put("result", result);
		if (result) {
			model.put("data", list);
		}
		return model;
	}

}
