package com.example.app2.model.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository repos;

	public void addArticle(Article a) {
		repos.save(a);
	}

	public Article getByNum(Integer num) {
		return repos.getOne(num);
	}

	public List<Article> getAll() {
		return repos.findAll();
	}

	// public List<Article> getByWriter(String id){} // user 쪽에서 처리

	public List<Article> getByTitle(String title) {
		return repos.findByTitleLike("%" + title + "%");//title과 완전 일치하지 않더라도 유사한 검색어의 결과를 반환하도록
	}

	public void editArticle(Article a) {
		repos.save(a);
	}

	public void delArticle(Integer num) {
		repos.deleteById(num);
	}
}
