package com.example.app2.model.join;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.app2.model.article.Article;

@Entity
public class Usertb {
	@Id
	private String id;
	private String pwd;
	private String name;
	private String email;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "writer", cascade = CascadeType.REMOVE)
	private List<Article> articles;

	public Usertb() {
	}

	public Usertb(String id, String pwd, String name, String email) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "Usertb [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + "]";
	}

}
