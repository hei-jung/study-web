package com.example.app2;

import java.util.List;
import java.util.Map;

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

import com.example.app2.model.article.Article;
import com.example.app2.model.join.UserService;
import com.example.app2.model.join.Usertb;

@Controller
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/user/join")
	public String joinForm() {
		return "user/join";
	}

	@PostMapping("/user/join")
	public String join(Usertb u) {
		service.addUser(u);
		return "redirect:/user";
	}

	@GetMapping("/user")
	public String userList(Model m) {
		List<Usertb> list = service.getUsers();
		m.addAttribute("list", list);
		return "user/list";
	}

	@GetMapping("/user/{id}")
	public String editForm(@PathVariable("id") String id, Model m) {
		Usertb u = service.getUser(id);
		m.addAttribute("u", u);
		return "user/edit";
	}

	@PostMapping("/user/edit")
	public String edit(Usertb u) {
		service.editUser(u);
		return "redirect:/user";
	}

	@PostMapping("/user/delete")
	public String del(@RequestParam("id") String id) {
		service.delUser(id);
		return "redirect:/user";
	}

	@GetMapping("/user/login")
	public void loginForm() {
	}

	@PostMapping("/user/login")
	public String login(HttpServletRequest req, @RequestParam("id") String id, @RequestParam("pwd") String pwd,
			Map<String, Boolean> map) {
		Usertb u = service.getUser(id);
		HttpSession session = req.getSession();
		String result = "";
		if (u != null && pwd.equals(u.getPwd())) {
			session.setAttribute("id", id);
			result = "redirect:/user/result";// '/result'
			map.put("result", true);
		} else {
			result = "redirect:/user/login";
			map.put("result", false);
		}
		return result;
	}
	
	@RequestMapping("/user/result")
	public void result(HttpServletRequest req, Model m) {
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		Usertb u = service.getUser(id);
		m.addAttribute("u", u);
	}

	@GetMapping("/article/listbywriter")
	public String listByWriter(@RequestParam("writer") String writer, Model m) {
		Usertb u = service.getUser(writer);
		List<Article> list = u.getArticles();
		m.addAttribute("list", list);
		return "article/list";
	}
	
	
}
