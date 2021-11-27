package ozguryazilim.movieCollection.DataAccess.Abstact;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ozguryazilim.movieCollection.Entities.Concrete.Actor;
import ozguryazilim.movieCollection.Entities.Concrete.Movie;

public interface ActorRepository extends JpaRepository<Actor, Long> {

	@Query(value = "SELECT * FROM actors a WHERE a.first_name LIKE %:keyword% ", nativeQuery = true)
	List<Actor> findActorsByKeyword(@Param("keyword") String keyword);
}
