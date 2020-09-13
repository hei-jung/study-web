package com.example.springApp1.model.board;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

	@Autowired
	private BoardMapper mapper;

	public void insert(Board b) {
		mapper.insert(b);
	}

	public Board selectById(int num) {
		return mapper.selectById(num);
	}

	public ArrayList<Board> selectByWriter(String writer) {
		return mapper.selectByWriter(writer);
	}

	public ArrayList<Board> selectByTitle(String title) {
		return mapper.selectByTitle(title);
	}

	public ArrayList<Board> select() {
		return mapper.select();
	}

	public void update(Board b) {
		mapper.update(b);
	}

	public void delete(int num) {
		mapper.delete(num);
	}
}
