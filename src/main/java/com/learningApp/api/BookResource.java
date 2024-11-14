package com.learningApp.api;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BookResource implements Serializable {
	private static final long serialVersionUID = 1L;
	private String bookId;
	private String name;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private java.time.LocalDate publishDate;
	
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookId() {
		return this.bookId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setPublishDate(java.time.LocalDate publishDate) {
		this.publishDate = publishDate;
	}
	public java.time.LocalDate getPublishDate() {
		return this.publishDate;
	}
}
