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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("account")
@SessionAttributes(types = AccountCreateForm.class)
public class AccountController {
	
	@ModelAttribute("accountCreateForm")
	public AccountCreateForm setUpAccountCreateForm() {
		return new AccountCreateForm();
	}

	@RequestMapping(path = "{accountId}", method = RequestMethod.GET)
	public String showAccount(
			@PathVariable String accountId,
			Model model) {
		model.addAttribute("data", accountId);
		return "account/index";
	}
	
	@GetMapping("createForm")
	public String form() {
		return "account/createForm";
	}
	
	@RequestMapping(path = "createForm", method = RequestMethod.POST, params = "confirm")
	public String postForm(@Validated AccountCreateForm form, BindingResult result, SessionStatus sessionStatus) {
		if (result.hasErrors()) {
			return "account/createForm";
		}
		// セッション情報削除
		sessionStatus.setComplete();
		return "account/createResult";
	}
}
