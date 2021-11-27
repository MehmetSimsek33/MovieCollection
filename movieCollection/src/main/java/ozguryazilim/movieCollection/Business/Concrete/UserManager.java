package ozguryazilim.movieCollection.Business.Concrete;


import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ozguryazilim.movieCollection.Business.Abstract.UserService;
import ozguryazilim.movieCollection.DataAccess.Abstact.UserRepository;
import ozguryazilim.movieCollection.Entities.Concrete.Role;
import ozguryazilim.movieCollection.Entities.Concrete.User;
import ozguryazilim.movieCollection.Entities.dto.UserRegistrationDto;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.stream.Collectors;


@Service
public class UserManager implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public User save(UserRegistrationDto registrationDto) {

			User user=new User(registrationDto.getFirstName(),
					registrationDto.getLastName(),
					registrationDto.getEmail(),
					passwordEncoder.encode(registrationDto.getPassword()), 
					Arrays.asList(new Role("ROLE_USER")));
				
			return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), 
				mapRolesToAuthorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

}
