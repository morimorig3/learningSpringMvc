package com.learningApp.app;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("echo")
public class EchoController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewInput(Model model) {
		EchoForm form = new EchoForm();
		model.addAttribute(form); // model名を入力しない場合はクラス名になる echoForm
		return "echo/input";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String echo(@Valid EchoForm form, BindingResult result) {
		// 引数で受け取ったformは自動的にmodelに追加される
		if(result.hasErrors()) {
			return "echo/input";
		}
		return "echo/output";
	}
}
