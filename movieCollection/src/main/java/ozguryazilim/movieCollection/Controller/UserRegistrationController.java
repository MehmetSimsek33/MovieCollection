package ozguryazilim.movieCollection.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ozguryazilim.movieCollection.Business.Abstract.UserService;
import ozguryazilim.movieCollection.Entities.dto.UserRegistrationDto;
@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	@Autowired
	UserService userService;
	
	
	  @ModelAttribute("user")
	    public UserRegistrationDto userRegistrationDto(){
	        return new UserRegistrationDto();
	    }
	
	  @GetMapping
	    public String showRegistrationForm(){
	        return "registration";
	    }
	@PostMapping
	public String registerUserAccount(@ModelAttribute("users") UserRegistrationDto registrationDto)
	{
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}
}
