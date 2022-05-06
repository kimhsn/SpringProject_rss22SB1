package fr.univrouen.rss22.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Feed")
@XmlAccessorType(XmlAccessType.NONE)
@Entity
@Table(name = "Feed")
public class Feed {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@XmlElement
	private String title;
	
	@XmlElement
	private String copyright;
	
	@XmlElement
	private String pubDate;
	
	@XmlElement
	private String link;
	
	
	public Feed() {
	}
	
	public Feed(long id, String title, String pubDate, String copyright, String link, Set<Item> items) {
		super();
		this.id = id;
		this.link = link;
		this.pubDate = pubDate;
		this.title = title;
		this.copyright = copyright;
	}
	
	
	public long getId() {
		return id;
	}
	public String getCopyright() {
		return copyright;
	}
	public String getLink() {
		return link;
	}
	public String getTitle() {
		return title;
	}
	
	public String getPubDate() {
		return pubDate;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	
	
	
	
	

}
