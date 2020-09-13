package com.example.app2;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app2.model.article.Article;
import com.example.app2.model.article.ArticleService;

@Controller
public class ArticleController {

	@Autowired
	private ArticleService service;

	@GetMapping("/article")
	public String writeForm() {
		return "article/form";
	}

	@PostMapping("/article")
	public String write(Article a) {
		service.addArticle(a);
		return "redirect:/article/list";
	}

	@GetMapping("/article/list")
	public String articleList(Model m) {
		List<Article> list = service.getAll();
		m.addAttribute("list", list);
		return "article/list";
	}

	@GetMapping("/article/listbytitle")
	public String listbytitle(@RequestParam("title") String title, Model m) {
		List<Article> list = service.getByTitle(title);
		m.addAttribute("list", list);
		return "article/list";
	}

	@GetMapping("/article/edit")
	public String editForm(@RequestParam("num") Integer num, Model m) {
		Article a = service.getByNum(num);
		m.addAttribute("a", a);
		return "article/edit";
	}

	@PostMapping("/article/edit")
	public String edit(Article a) {
		a.setW_date(new Date());
		service.editArticle(a);
		return "redirect:/article/list";
	}

	@GetMapping("/article/delete")
	public String del(@RequestParam("num") Integer num) {
		service.delArticle(num);
		return "redirect:/article/list";
	}

	@GetMapping("/article/json")
	public String json(Model m) {
		List<Article> list = service.getAll();
		m.addAttribute("list", list);
		return "article/json";
	}
}
