package com.learningApp.app;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class AccountCreateForm implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "入力してください")
	@Size(min = 1, max = 50, message = "入力してください")
	private String name = "たかし";
	
	@NotNull
	@Size(min = 9, max = 11)
	private String tel;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	
	@NotNull
	@Size(min = 9, max = 250)
	private String email;
	

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return this.tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
