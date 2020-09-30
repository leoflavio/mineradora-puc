package com.mina.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mina.demo.nivelalerta.Mensagem;




@Controller
@RequestMapping("/listar-eventos")
public class MsgController {
	
	@GetMapping
	public ModelAndView listar() throws InterruptedException {
		
		ModelAndView modelAndView = new ModelAndView("eventos");
		modelAndView.addObject("eventos", Mensagem.getInstance().getValue());
		return modelAndView;
	}
}