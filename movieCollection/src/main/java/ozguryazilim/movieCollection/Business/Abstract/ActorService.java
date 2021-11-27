package ozguryazilim.movieCollection.Business.Abstract;

import java.util.List;

import ozguryazilim.movieCollection.Entities.Concrete.Actor;
import ozguryazilim.movieCollection.Entities.Concrete.Movie;


public interface ActorService {
	
	void addActor(Actor actor);
	void deleteActor(long id);
	Actor getActorById(long id);
	List<Actor> getAllActor();
	List<Actor> getByKeyword(String keyword);
}
