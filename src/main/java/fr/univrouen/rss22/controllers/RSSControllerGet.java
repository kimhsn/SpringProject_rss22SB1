package fr.univrouen.rss22.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fr.univrouen.rss22.model.Item;
import fr.univrouen.rss22.repository.ItemRepository;

@Controller
public class RSSControllerGet {

	@Autowired
	ItemRepository ir;
	@GetMapping(value="/rss22/resume/html")	
    public ModelAndView getItemsHTML(Model m) {
		
		m.addAttribute("items", ir.findAll());
		ModelAndView mdav = new ModelAndView();
		mdav.setViewName("articles.html");
		return mdav;
	}
	
	
	@RequestMapping(value = "/rss22/resume/xml", produces = MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody List<Item> getItemsXML(){
		List<Item> list=ir.findAll();
		return list;
	  }
	
	
	@GetMapping(value="/rss22/html/{guid}", produces = MediaType.APPLICATION_XML_VALUE)
	public ModelAndView getHtmlDetailsItem(@PathVariable("guid") long guid, Model m) {
	    Item item = ir.findById(guid).orElseThrow(() -> new absentException(guid+" introuvable"));
	    
	    m.addAttribute("item", item);
	    ModelAndView mdav = new ModelAndView();
		mdav.setViewName("detailArticle.html");
		return mdav;
	}
	
	
	
	@RequestMapping(value = "/rss22/resume/xml/{guid}", produces = MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody Item getXmlDetailsItem(@PathVariable("guid") long guid, Model m) {
		Item i = ir.findById(guid).orElseThrow(() -> new absentException(guid+" introuvable"));
		m.addAttribute("item", i);
		return i;
	}
	
	
	
	//Bonus 
	
	 @RequestMapping(value = "/search")
	 public ModelAndView searchItemsByKeyword(Model m, @RequestParam(name = "keyW") String keyW) {
		 List<Item> Items;
		 ModelAndView mav = new ModelAndView();
		 if(keyW==null) {
			  Items = ir.findAll();
			  m.addAttribute("items", Items);
	  }else {
		  if(keyW.contains("/")) {
			  Items= ir.findByDate(keyW);
			   m.addAttribute("items", Items);
		  }else {
		  Items= ir.findByTitle(keyW);
		   m.addAttribute("items", Items);
	  }
		  }
	  mav.setViewName("articles.html");
	  return mav;
	 } 
	
	/*
	@RequestMapping(value = "/search")
	 public List<Item> searchItemsByKeyword(Model m, @RequestParam(name = "keyW") String keyW) {
		 List<Item> Items;
		 if(keyW==null) {
			  Items = ir.findAll();
			  m.addAttribute("items", Items);
	  }else {
		  if(keyW.contains("/")) {
			  Items= ir.findByDate(keyW);
			   m.addAttribute("items", Items);
		  }else {
		  Items= ir.findByTitle(keyW);
		   m.addAttribute("items", Items);
	  }
		  }
	  return Items;
	 } 
*/
}
