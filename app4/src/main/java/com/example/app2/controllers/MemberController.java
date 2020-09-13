package com.example.app2.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app2.model.join.MemberType;
import com.example.app2.model.join.Shop_Member;
import com.example.app2.model.join.Shop_MemberService;
import com.example.app2.model.order.MyOrder;
import com.example.app2.model.order.OrderType;
import com.example.app2.model.product.Product;

@Controller
public class MemberController {
	@Autowired
	private Shop_MemberService service;

	@GetMapping("/member")
	public String form() {
		// 회원가입 페이지로 이동
		return "member/form";
	}

	@PostMapping("/member")
	public String join(Shop_Member sm) {
		// 회원가입
		service.saveMember(sm);
		return "redirect:/member/login";
	}

	@GetMapping("/member/login")
	public void loginForm() {
	}

	@PostMapping("/member/login")
	public String login(Shop_Member sm, HttpServletRequest req) {
		HttpSession session = req.getSession();
		Shop_Member a = service.getMember(sm.getId());
		boolean flag = false;
		String pwd = "";
		try {
			pwd = a.getPwd();
			if (pwd.equals(sm.getPwd())) {
				flag = true;
				System.out.println("로그인 성공!!");
			} else {
				System.out.println("패스워드 불일치");// 서버 출력 메시지1. 사용자에겐 안보임
			}
		} catch (EntityNotFoundException e) {
			System.out.println("아이디 불일치");// 확인용 서버 출력 메시지2
		}

		String result = "redirect:/member/login";
		if (flag) { // 일치하는 아이디가 존재하고, 해당 아이디에 대한 패스워드가 일치할 경우
			session.setAttribute("id", sm.getId());
//			session.setAttribute("type", a.getType());
			if (a.getType() == MemberType.CONSUMER) {
				result = "redirect:/product/list";// 상품 전체 리스트
			} else if (a.getType() == MemberType.SELLER) {
				// 자신이 등록한 상품 리스트
				result = "redirect:/product/listbyseller/" + sm.getId();
			}
		}
		return result;
	}

	@RequestMapping("/member/logout")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		session.removeAttribute("id");
		session.invalidate();
		return "redirect:/member/login";
	}

	@RequestMapping("/member/idCheck")
	public String idCheck(@RequestParam("id") String id, Model m) {
		// 아이디 중복체크
		Shop_Member a = service.getMember(id);
		boolean flag = false;
		try {
			a.getPwd();
		} catch (EntityNotFoundException e) {
			flag = true;
		}
		m.addAttribute("flag", flag);
		return "member/idcheck";
	}

	@GetMapping("/product/list")
	public String list(Model m) {
		List<Shop_Member> members = service.getMembers();
		List<Product> list = new ArrayList<Product>();
		for (Shop_Member sm : members) {
			list.addAll(sm.getProducts());
		}
		m.addAttribute("list", list);
		return "product/all";
	}

	@GetMapping("/product/listbyseller/{seller}")
	public String listbyseller(@PathVariable("seller") String seller, Model m) {
		Shop_Member sm = service.getMember(seller);
		List<Product> list = sm.getProducts();
		m.addAttribute("list", list);
		return "product/list";
	}

//	@GetMapping("/order/mylist/{con}/{type}")
//	public String myorderlist(@PathVariable("con") String con, @PathVariable("type") OrderType type, Model m) {
//		Shop_Member sm = service.getMember(con);
//		List<MyOrder> list = sm.getOrders();
//		List<MyOrder> list_type = new ArrayList<MyOrder>();
//		for (MyOrder o : list) {
//			if (o.getType() == type) {
//				list_type.add(o);
//			}
//		}
//		m.addAttribute("list", list_type);
//		return "order/mylist";
//	}

	@GetMapping("/order/myorder/{con_id}")
	public String myorder(@PathVariable("con_id") String con_id, Model m) {
		Shop_Member sm = service.getMember(con_id);
		List<MyOrder> list = sm.getOrders();
		m.addAttribute("list", list);
		return "order/myorder";
	}
	
	@GetMapping("/order/myorder/{con_id}/{type}")
	public String myordertype(@PathVariable("con_id") String con_id, @PathVariable("type") OrderType type, Model m){
		System.out.println(con_id+"/"+type);
		Shop_Member sm = service.getMember(con_id);
		List<MyOrder> temp = sm.getOrders();
		List<MyOrder> list = new ArrayList<MyOrder>();
		for(MyOrder o:temp){
			if(o.getType()==type){
				list.add(o);
			}
		}
		m.addAttribute("list", list);
		return "order/myorder";
	}
}
