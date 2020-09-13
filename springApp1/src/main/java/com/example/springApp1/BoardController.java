package com.example.springApp1;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.springApp1.model.board.Board;
import com.example.springApp1.model.board.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;

	/* 게시글 추가 */
	@GetMapping("/board/write")
	public void writeForm() {
	}

	@PostMapping("/board/write")
	public String write(@ModelAttribute("b") Board b) {
		service.insert(b);
		return "redirect:/board/list";
	}

	/* 게시판(게시글 목록) */
	@GetMapping("/board/list")
	public ModelAndView modelList() {
		ModelAndView mav = new ModelAndView("/board/list");
		ArrayList<Board> list = service.select();
		mav.addObject("list", list);
		return mav;
	}
	
	/* 게시판(게시글 목록): 선생님 코드 */
//	@RequestMapping("/board/list")
//	public void list(Map<String, ArrayList<Board>> map){
//		ArrayList<Board> list = service.getAll();
//		map.put("list", list);
//	}
	
	/* 게시글 수정 */
	@RequestMapping("/board/edit")
	public void editForm(Map<String, Board> map, @RequestParam("num") int num){
		Board b = service.selectById(num);
		map.put("b", b);
	}

	@PostMapping("/board/edit")
	public String edit(@ModelAttribute("b") Board b) {
		service.update(b);
		return "redirect:/board/list";
	}
	
	/* 게시글 삭제 */
	@RequestMapping("/board/del")
	public String del(@RequestParam("num") int num){
		service.delete(num);
		return "redirect:/board/list";
	}
}
