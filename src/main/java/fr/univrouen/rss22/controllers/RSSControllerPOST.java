package fr.univrouen.rss22.controllers;


import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.xml.sax.SAXException;

import fr.univrouen.rss22.model.Feed;
import fr.univrouen.rss22.repository.FeedRepository;
import fr.univrouen.rss22.repository.ItemRepository;

@Controller
public class RSSControllerPOST {
	@Autowired
	ItemRepository ir;
	@Autowired
	FeedRepository fr;
	
	
	
	@PostMapping(value="/rss22/insert", produces = MediaType.APPLICATION_XML_VALUE)
	  public String InsererArticle(@RequestParam(value = "xmlInput") String xml) throws SAXException, IOException {
		
		if (validationSchemaXML(xml)==true) {
			try {
				Feed f;
	            JAXBContext cx;
	            cx= JAXBContext.newInstance(Feed.class);
	            Unmarshaller mch = cx.createUnmarshaller();
	            f = (Feed) mch.unmarshal(new StringReader(xml));
	 	       	fr.save(f);
	 	       return "redirect:/rss22/resume/html";
	        } catch (JAXBException e) {
	            e.printStackTrace();
	        }
		}
	       	return "redirect:/rss22/resume/html";
	  }
	
	
	public static boolean validationSchemaXML(String xml) throws SAXException, IOException{
            Schema s;
		    SchemaFactory sf;
		    Validator v;
		    StringReader r;
            sf= SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            s = sf.newSchema(new File("src/main/resources/static/validation.xsd"));
            v = s.newValidator();
            r = new StringReader(xml);
            v.validate(new StreamSource(r));
            return true;
    }
}
