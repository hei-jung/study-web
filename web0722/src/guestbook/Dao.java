package guestbook;

import java.util.ArrayList;

public interface Dao {

	void insert(Article a);

	Article select(int num);// 글번호로 글 하나 검색

	ArrayList<Article> selectAll();// 글전체 검색

	void update(Article a);// 글번호로 검색한 글의 내용 수정

	void delete(int num);// 글번호로 검색한 글 삭제
}
