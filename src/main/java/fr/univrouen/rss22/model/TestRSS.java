package fr.univrouen.rss22.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

public class TestRSS {
	public String loadFileXML() {
		Resource resource = new DefaultResourceLoader().
				getResource("classpath:xml/item.xml");	
		
		try {
			File file = resource.getFile();
			return new String(
				      Files.readAllBytes(file.toPath()));
		} catch (IOException e) {
			return "Error : " + e.getMessage();
		}
	}
}
