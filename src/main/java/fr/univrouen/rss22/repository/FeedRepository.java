package fr.univrouen.rss22.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import fr.univrouen.rss22.model.Feed;

public interface FeedRepository extends JpaRepository<Feed, Long >{
	

}
