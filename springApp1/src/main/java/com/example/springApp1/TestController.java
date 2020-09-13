package com.example.springApp1;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.springApp1.model.join.Member;
import com.example.springApp1.model.join.MemberService;

@Controller
public class TestController {

	@Autowired // 의존성 자동 주입. 타입이나 이름이 동일한 bean을 찾아서 넣어줌
	private MemberService service;

	// 요청 url별로 실행할 코드 작성
	@RequestMapping("/")
	public String home() {// String: 뷰 페이지 경로
		return "index";
	}

	@GetMapping("/edit") // 폼 페이지를 보내줌
	public void editForm() {// 반환값이 void이면 뷰 페이지는 mapping url과 동일
	}

	@PostMapping("/edit") // 파라미터 받아서 전송
	public String edit(@ModelAttribute("m") Member m) {
		return "editResult";
	}

	@RequestMapping("list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("list");// 1.뷰페이지 경로를 생성자에 넣는 경우
		// mav.setViewName("list");// 2.뷰페이지 경로를 setViewName에 지정하는 경우
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		mav.addObject("list", list);
		return mav;
	}

	@GetMapping("/member/list")
	public ModelAndView modelList() {
		ModelAndView mav = new ModelAndView("list2");
		ArrayList<Member> list = service.getMembers();
		mav.addObject("m", list);
		return mav;
	}
}
