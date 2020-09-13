package com.example.app2.model.article;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;

import com.example.app2.model.join.Usertb;

@Entity
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_sequence")
	@SequenceGenerator(name = "article_sequence", sequenceName = "seq_article")
	private Integer num;

	@ManyToOne // db의 다대1
	@JoinColumn(name = "writer", nullable = false)
	private Usertb writer;
	private String title;
	private Date w_date;
	private String content;

	@PrePersist
	public void beforeCreate() {
		w_date = new Date();
	}

	public Article() {
	}

	public Article(Integer num, Usertb writer, String title, Date w_date, String content) {
		super();
		this.num = num;
		this.writer = writer;
		this.title = title;
		this.w_date = w_date;
		this.content = content;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Usertb getWriter() {
		return writer;
	}

	public void setWriter(Usertb writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getW_date() {
		return w_date;
	}

	public void setW_date(Date w_date) {
		this.w_date = w_date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Article [num=" + num + ", writer=" + writer + ", title=" + title + ", w_date=" + w_date + ", content="
				+ content + "]";
	}
}
