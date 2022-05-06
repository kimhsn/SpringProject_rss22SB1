package fr.univrouen.rss22.model;
import java.util.Set;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;


@XmlRootElement(name = "Item")
@XmlAccessorType(XmlAccessType.NONE)
@Entity
@Table(name = "Item")
public class Item {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	@XmlAttribute
	private long guid;
	
	@XmlElement
	private String title;
	
	@XmlElement
	private String content;
	
	@XmlElement
	private String category;
	
	@XmlElement
	private String image;
	
	@XmlElement
	private String published;
	
	@XmlElementWrapper(name = "Author")
    @XmlElement(name = "Author")
	@OneToMany(cascade = CascadeType.ALL)
    private Set<Author> autors;
	@ManyToOne
    @JoinColumn(name = "IdFeed")
    Feed feed;
	
	public Item() {}

	public Item(long guid, String title, String published, String category, String image, String content,
			Set<Author> autors) {
		super();
		this.guid = guid;
		this.title = title;
		this.published = published;
		this.category = category;
		this.image = image;
		this.content = content;
		this.autors = autors;
	}
	
	public void setFeed(Feed feed) {
		this.feed = feed;
	}
	
	public void setGuid(long guid) {
		this.guid = guid;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public Feed getFeed() {
		return feed;
	}
	
	public long getGuid() {
		return guid;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getPublished() {
		return published;
	}
	
	public Set<Author> getAutors() {
		return autors;
	}
	public void setAutors(Set<Author> autors) {
		this.autors = autors;
	}
	public void setPublished(String published) {
		this.published = published;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
