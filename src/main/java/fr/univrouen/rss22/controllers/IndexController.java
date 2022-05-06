package fr.univrouen.rss22.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mdav = new ModelAndView();
		mdav.setViewName("home.html");
		return mdav;
	}
	
	@GetMapping("/help")
	public ModelAndView help() {
		ModelAndView mdav = new ModelAndView();
		mdav.setViewName("help.html");
		return mdav;
	}
}
