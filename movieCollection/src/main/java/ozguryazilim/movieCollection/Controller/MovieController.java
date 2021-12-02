package ozguryazilim.movieCollection.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ozguryazilim.movieCollection.Business.Abstract.ActorService;
import ozguryazilim.movieCollection.Business.Abstract.MovieService;
import ozguryazilim.movieCollection.Entities.Concrete.Actor;
import ozguryazilim.movieCollection.Entities.Concrete.Movie;

@Controller
public class MovieController  {
		
	private MovieService _movieService;
	@Autowired
	private ActorService actorService;
	

	public MovieController(MovieService movieService) {
		_movieService = movieService;
	
	}
		
		@GetMapping("/")
		public String viewHomePage(Model model,String keyword)
		{		
			
				return findPaginated(1,"filmName","asc",model,keyword);
			
			
		}
		
		@GetMapping("/newMovieForm")
		public String newMovieForm(Model model)
		{
			Movie movie = new Movie();
			
			model.addAttribute("movie", movie);
			model.addAttribute("actor", actorService.getAllActor());
			return "new_movie";
		}
		
		@PostMapping("/saveMovie")
		public String saveMovie(@ModelAttribute("movie") Movie movie)
		{
			_movieService.addMovie(movie);
			return "redirect:/";
		}
		@GetMapping("/showFormForUpdate/{id}")
		public String showFormForUpdate(@PathVariable (value = "id") long id, Model model) {
			
			Movie movie = _movieService.getMovieById(id);
			
			model.addAttribute("movie", movie);
			return "update_movie";
		}
		@GetMapping("/deleteMovie/{id}")
		public String deleteMovie(@PathVariable (value = "id") long id)
		{
			this._movieService.deleteMovie(id);
			return "redirect:/";
		}
		
		@GetMapping("/page/{pageNo}")
		public String findPaginated(@PathVariable(value="pageNo") int pageNo,@RequestParam("sortField") String sortField,
				@RequestParam("sortDir") String sortDir,Model model,String keyword )
		{
		
			int pageSize=5;
			Page<Movie> page=_movieService.findPaginated(pageNo, pageSize,sortField,sortDir);
		
			
			 if(keyword != null){
				 
		            model.addAttribute("listMovies",_movieService.getByKeyword(keyword));
		        }else {
		        	List<Movie> listMovies=page.getContent();
		        	model.addAttribute("listMovies",listMovies);
		        }
			
				
			model.addAttribute("sortField", sortField);
			model.addAttribute("sortDirection", sortDir);
			model.addAttribute("reverseSortDirection", sortDir.equals("asc") ? "desc" : "asc");
			
			model.addAttribute("currentPage", pageNo);
			model.addAttribute("totalPages", page.getTotalPages());
			model.addAttribute("totalItems", page.getTotalElements());
		
			
			return "index";
		}
		
		@PostMapping("/showSearch")
		 public String home(@ModelAttribute("searchWord") Model model, String searchWord) {
		
			 List<Movie> listMovie = _movieService.getByKeyword(searchWord);
			 	
				model.addAttribute("listMovies", listMovie);
				model.addAttribute("searchWord", searchWord);
				model.addAttribute("listMoviesSize", listMovie.size());
				return "search";
	
				
		 }

}