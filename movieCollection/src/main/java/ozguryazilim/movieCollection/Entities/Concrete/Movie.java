package ozguryazilim.movieCollection.Entities.Concrete;

import java.time.LocalDate;
import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movies")
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data

public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "film_name")
	private String filmName;

	@Column(name = "release_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate releaseDate;

	@Column(name = "type")
	private String type;

	@Column(name = "descrption", length = 1000)
	private String descrption;

	@Column(name = "movie_media")	
	private String media;

	@Column(name = "language")
	private String language;

	@ManyToMany()
	@JoinTable( joinColumns = { @JoinColumn(name = "movie_id") }, inverseJoinColumns = {
			@JoinColumn(name = "actor_id") })
	@JsonIgnore
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Set<Actor> actors = new HashSet<>();

//	@OneToMany(mappedBy = "movie")
//	public List<Actor> actors;

}