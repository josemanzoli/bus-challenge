package com.manzoli.bus.route.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @author jmanzol
 * @since 1.0-SNAPSHOT
 * Controller to redirect / to swagger-ui
 *
 */
@Controller
public class HomeController {

	@RequestMapping(path="/")
	public String home(){
		return "redirect:swagger-ui.html";
	}
}
