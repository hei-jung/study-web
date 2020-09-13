package com.example.SpringApp2;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SpringApp2.model.join.Member;
import com.example.SpringApp2.model.join.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;

	/* 회원가입 */
	@GetMapping("/member/join")
	public void joinForm() {

	}

	@PostMapping("/member/join")
	public String join(@ModelAttribute("m") Member m) {
		service.addMember(m);
		return "/member/login";
		// return "redirect:/member/list";
	}

	/* 로그인 */
	@GetMapping("/member/login")
	public void loginForm() {
	}

	@PostMapping("/member/login")
	public String login(HttpServletRequest req, @RequestParam("id") String id, @RequestParam("pwd") String pwd,
			Map<String, Boolean> map) {
		Member m = service.getMember(id);
		HttpSession session = req.getSession();
		String result = "";
		if (m != null && pwd.equals(m.getPwd())) {
			session.setAttribute("id", id);
			result = "redirect:/member/result";
			map.put("result", true);
		} else {
			result = "redirect:/member/login";
			map.put("result", false);
		}
		return result;
	}

	/* 수정 */
	@GetMapping("/member/edit")
	public void editForm(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		String id = (String) session.getAttribute("id");
		Member m = service.getMember(id);
		req.setAttribute("m", m);
		// void -> ModelAndView로 바꾸고
		// ModelAndView mav = new ModelAndView("member/edit");
		// return mav;
	}

	@RequestMapping("/member/result")
	public void result() {

	}

	@PostMapping("/member/edit")
	public String edit(@ModelAttribute("m") Member m) {
		service.editMember(m);
		return "redirect:/member/result";
	}

	/* 로그아웃 */
	@GetMapping("/member/logout")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		session.removeAttribute("id");
		session.invalidate();
		return "redirect:/member/login";
	}

	/* 탈퇴 */
	@GetMapping("/member/out")
	public String out(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		String id = (String) session.getAttribute("id");
		service.delMember(id);
		return "redirect:/member/login";
	}

	@GetMapping("/test/map")
	public void testMap(Map<String, String> map) {
		map.put("test1", "aaa");
		map.put("test2", "bbb");
		map.put("test3", "ccc");
	}

}
