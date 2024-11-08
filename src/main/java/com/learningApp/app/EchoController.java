package com.learningApp.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String echo(EchoForm form) {
		// 引数で受け取ったformは自動的にmodelに追加される
		return "echo/output";
	}
}
