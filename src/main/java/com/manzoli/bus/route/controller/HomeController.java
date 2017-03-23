package com.manzoli.bus.route.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(path="/")
	public String home(){
		return "redirect:swagger-ui.html";
	}
}
