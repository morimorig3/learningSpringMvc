package com.learningApp.app;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("echo")
public class EchoController {
	
	@GetMapping
	public String viewInput(Model model, Locale locale) {
		EchoForm form = new EchoForm();
		model.addAttribute(form); // model名を入力しない場合はクラス名になる echoForm
		model.addAttribute("locale" ,locale.toString());
		return "echo/input";
	}
	
	@PostMapping
	public String echo(@Valid EchoForm form, BindingResult result) {
		// 引数で受け取ったformは自動的にmodelに追加される
		if(result.hasErrors()) {
			return "echo/input";
		}
		return "echo/output";
	}
}
