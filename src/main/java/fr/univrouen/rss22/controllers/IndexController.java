package fr.univrouen.rss22.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {
	
	/* @GetMapping("/")
	public String index() {
		return "Hello rss22 !";
	} */
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mdav = new ModelAndView();
		mdav.setViewName("index.html");
		return mdav;
	}
	
	@GetMapping("/help")
	public ModelAndView help() {
		ModelAndView mdav = new ModelAndView();
		mdav.setViewName("help.html");
		return mdav;
	}
	
	@GetMapping("/rss22/resume/xml")
	public String getListRSSinXML() {
		return "";
	}

}
