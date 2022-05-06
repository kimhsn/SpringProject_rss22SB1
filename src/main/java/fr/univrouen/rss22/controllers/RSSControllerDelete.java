package fr.univrouen.rss22.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import fr.univrouen.rss22.repository.ItemRepository;

@Controller
public class RSSControllerDelete {
	@Autowired
	ItemRepository ir;
	@GetMapping(value="/rss22/delete/{guid}", produces = MediaType.APPLICATION_XML_VALUE)
	public String deleteArticleInBase(@PathVariable("guid") long guid) {
	    ir.deleteById(guid);
	    //rester sur la meme page
	    return "redirect:/rss22/resume/html";
	}
	
}
