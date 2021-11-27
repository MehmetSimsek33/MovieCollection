package ozguryazilim.movieCollection.Entities.Concrete;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="movies")
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "languages" })
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="film_name")
	private String filmName;
	
	@Column(name="release_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate releaseDate;
	
	@Column(name="type")
	private String type;
	
	@Column(name="descrption" ,length = 1000)
	private String descrption;
	
	 @Column(name = "movie_media")
	 private String media;
	 
	 @Column(name = "language")
	 private String language;
	 
	 @OneToMany(mappedBy = "movie")
	public List<Actor> actors;
	
	 
}
