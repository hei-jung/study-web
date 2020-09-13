package com.example.app2.model.article;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

	ArrayList<Article> findByTitleLike(String title);
}
