package ozguryazilim.movieCollection.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ozguryazilim.movieCollection.Business.Abstract.ActorService;
import ozguryazilim.movieCollection.Business.Abstract.MovieService;
import ozguryazilim.movieCollection.Entities.Concrete.Actor;
import ozguryazilim.movieCollection.Entities.Concrete.Movie;

@Controller
public class ActorController {
	
	@Autowired
	private ActorService actorService;
	@Autowired
	MovieService _movieService;
	@GetMapping("/actorList")
	public String actorList(Model model,String keyword) {
	
		 if(keyword != null){
	            model.addAttribute("listActor",actorService.getByKeyword(keyword));
	        }else {
	         model.addAttribute("listActor", actorService.getAllActor());
	        }
		return "actor_list";
	}
	
	@GetMapping("/showNewActorForm")
	public String showNewActorForm(Model model) {
		Actor actor = new Actor();
		model.addAttribute("actor", actor);
		model.addAttribute("movie", _movieService.getAllMovie());
		return "new_actors";
	}
	
	@GetMapping("/deleteActor/{id}")
	public String deleteMovie(@PathVariable (value = "id") long id)
	{
		this.actorService.deleteActor(id);
		return "redirect:/actorList";
	}
	
	@PostMapping("/saveActor")
	public String saveActor(@ModelAttribute("actor") Actor actor)
	{
		actorService.addActor(actor);
		return "redirect:/actorList";
	}
	
	
	@GetMapping("/showActorFormForUpdate/{id}")
	public String showActorFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		Actor actor = actorService.getActorById(id);
		model.addAttribute("actor", actor);
		return "update_actor";
	}


}
