package fr.univrouen.rss22.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.univrouen.rss22.model.Item;

@RestController
public class RSSController {
    @GetMapping("/resume")
    public String getListRSSinXML(){
        return "Envoie de la liste des flux RSS";
    }

    @GetMapping("/guid")
	public String getRSSinXML(@RequestParam(value = "guid") String texte) {
		return ("Détail du flux RSS demandé : " + texte);
	}
    
    @GetMapping("/test")
    public String getTestRSSinXML(@RequestParam(value="nb") int nb, @RequestParam(value="search") String search) {
        return "Test <br> guid = " + nb + "<br> titre = " + search;
    }
    
    @RequestMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody Item getXML() {
		Item it = new Item("12345678","Test item","2022-05-01T11:22:33");
		return it;
	}
} 