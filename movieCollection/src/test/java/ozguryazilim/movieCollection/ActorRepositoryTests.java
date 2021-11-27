package ozguryazilim.movieCollection;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import ozguryazilim.movieCollection.DataAccess.Abstact.ActorRepository;
import ozguryazilim.movieCollection.Entities.Concrete.Actor;
import ozguryazilim.movieCollection.Entities.Concrete.Movie;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ActorRepositoryTests {
	
	@Autowired
	ActorRepository actorRepository;

	@Test
	@Rollback(value = false)
	@Order(1)
	public void SaveActorTest()
	{
		Actor actor=Actor.builder().firstName("Cüney").lastName("Arkın").build();
		actorRepository.save(actor);
		Assertions.assertThat(actor.getId()).isGreaterThan(0);


	}
	@Test
	@Rollback(value = false)
	@Order(3)
	public void UpdateActorTest()
	{
		Actor actor = actorRepository.findById(5L).get();
		actor.setFirstName("Leonardo");
		actor.setLastName("Di Caprio");
		Actor actorUpdate = actorRepository.save(actor);

		Assertions.assertThat(actorUpdate.getFirstName()).isEqualTo("Leonardo");
	}
	@Test
	@Order(4)
	public void getListActorsTest() {
		List<Actor> actorList = actorRepository.findAll();
		Assertions.assertThat(actorList.size()).isGreaterThan(0);
	}

	@Test
	@Order(5)
	public void getActorTest() {

		Actor actor = actorRepository.findById(5L).get();
		Assertions.assertThat(actor.getId()).isEqualTo(1);
	}
}
