package ozguryazilim.movieCollection;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.springframework.test.annotation.Rollback;
import ozguryazilim.movieCollection.DataAccess.Abstact.MovieRepository;
import ozguryazilim.movieCollection.Entities.Concrete.Movie;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class MovieRepositoryTests {

	@Autowired

	private MovieRepository movieRepository;
	
	@Test
	@Rollback(value = false)
	@Order(1)
	public void SaveMovieTest()
	{
		Movie movie=Movie.builder().filmName("Arog").
				media("https://i.ytimg.com/vi/H2uGBHwvgNs/maxresdefault.jpg")
				.descrption("A.R.O.G, Cem Yılmaz'ın yazıp Ali Taner Baltacı ile birlikte yönettiği filmidir.")
				.type("Bilim Kurgu Komedi")
				.build();
		movieRepository.save(movie);
		Assertions.assertThat(movie.getId()).isGreaterThan(0);
	}
	
	
	
	@Test
	@Rollback(value = false)
	@Order(3)
	public void UpdateMovieTest()
	{
		Movie movie = movieRepository.findById(15L).get();
		movie.setFilmName("Hobbit: Smaug'un Çorak Toprakları");
		movie.setDescrption("Hobbit: Smaug'un Çorak Toprakları Peter Jackson'ın senaryosuna katkıda bulunduğu, yapımcılığını ve yönetmenliğini üstlendiği destansı fantezi macera türündeki 2013 tarihli filmdir.");
		movie.setType("Fantezi Macera");
		movie.setMedia("https://tr.web.img4.acsta.net/pictures/210/562/21056253_20131108151938568.jpg");
		
		Movie movieUpdate = movieRepository.save(movie);

		Assertions.assertThat(movieUpdate.getFilmName()).isEqualTo("Hobbit: Smaug'un Çorak Toprakları");
	}
	@Test
	@Order(4)
	public void getListMovieTest() {
		List<Movie> movieList = movieRepository.findAll();
		Assertions.assertThat(movieList.size()).isGreaterThan(0);
	}

	@Test
	@Order(5)
	public void getMovieTest() {

		Movie movie = movieRepository.findById(15L).get();
		Assertions.assertThat(movie.getId()).isEqualTo(1);
	}

	}
