package com.cibertec.models;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tweet")
public class Tweet implements Serializable {
	private static final long serialVersionUID = 1L;
	public Tweet() {}
	
	public Tweet(long id, String author, Date time, String content) {
		super();
		this.id = id;
		this.author = author;
		this.time = time;
		this.content = content;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_tweet")
	Long id;
	@Column(name = "usu_tweet")
	String author;
	@Column(name="hora_tweet")
	Date time;
	@Column(name="content_tweet")
	String content;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;

	}

}
