package ozguryazilim.movieCollection.DataAccess.Abstact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ozguryazilim.movieCollection.Entities.Concrete.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
