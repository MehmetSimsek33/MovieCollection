package ozguryazilim.movieCollection.Business.Abstract;


import org.springframework.security.core.userdetails.UserDetailsService;

import ozguryazilim.movieCollection.Entities.Concrete.User;
import ozguryazilim.movieCollection.Entities.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

	User save(UserRegistrationDto registrationDto);
}
