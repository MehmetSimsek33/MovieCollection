package ozguryazilim.movieCollection.Business.Concrete;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ozguryazilim.movieCollection.Business.Abstract.ActorService;
import ozguryazilim.movieCollection.DataAccess.Abstact.ActorRepository;
import ozguryazilim.movieCollection.Entities.Concrete.Actor;
@Service
public class ActorManager implements ActorService{

	@Autowired
	ActorRepository actorRepository;
	
	@Override
	public void addActor(Actor model) {
		Actor actor = new Actor();
		
		fill(actor, model);
		actorRepository.save(actor);
	   
		
	}
	private void fill(Actor actor, Actor model)
	{
       actor.setFirstName(model.getFirstName());
       actor.setLastName(model.getFirstName());
       actor.setMovies(model.getMovies());
    }

	@Override
	public void deleteActor(long id) {
		actorRepository.deleteById(id);
	}

	@Override
	public Actor getActorById(long id) {
		Optional<Actor> optional = actorRepository.findById(id);
		Actor actor = null;
		if (optional.isPresent()) {
			actor = optional.get();
		} 
		else {
			throw new RuntimeException("Id ye ait film bulunamadi ::" + id);
		}
		return actor;
	}

	@Override
	public List<Actor> getAllActor() {
		return actorRepository.findAll();
	}

	@Override
	public List<Actor> getByKeyword(String keyword) {
		
		List<Actor> seachActor = actorRepository.findActorsByKeyword(keyword);
		return seachActor;
	}

}