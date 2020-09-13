package com.example.SpringApp2.model.board;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {

	void insert(Board b);

	Board selectById(int num);

	ArrayList<Board> selectByWriter(String writer);

	ArrayList<Board> selectByTitle(String title);

	ArrayList<Board> select();

	void update(Board b);

	void delete(int num);
}
