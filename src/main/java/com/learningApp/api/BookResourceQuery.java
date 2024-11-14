package com.learningApp.api;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class BookResourceQuery implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate publishDate;
	
	public String getName() {
		return name;
	}
	public LocalDate getPublishDate() {
		return publishDate;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}
}
