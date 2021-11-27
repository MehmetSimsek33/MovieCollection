package ozguryazilim.movieCollection.DataAccess.Abstact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

import ozguryazilim.movieCollection.Entities.Concrete.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	@Query(value = "SELECT * FROM movies m  WHERE m.film_name LIKE  %:keyword% OR m.type LIKE %:keyword%", nativeQuery = true)
	List<Movie> findMoviesByKeyword(@Param("keyword") String keyword);
	
}
