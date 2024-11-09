package com.learningApp.app;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("account")
public class AccountController {

	@RequestMapping(path = "{accountId}", method = RequestMethod.GET)
	public String showAccount(
			@PathVariable String accountId,
			Model model) {
		model.addAttribute("data", accountId);
		return "account/index";
	}
	
	
	@ModelAttribute
	public AccountCreateForm setUpForm() {
	return new AccountCreateForm();	
	}
	
	@GetMapping("createForm")
	public String form(Model model) {
		return "account/createForm";
	}
	
	@RequestMapping(path = "createForm", method = RequestMethod.POST, params = "confirm")
	public String postForm(@Validated AccountCreateForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "account/createForm";
		}
		return "account/createResult";
	}
}
