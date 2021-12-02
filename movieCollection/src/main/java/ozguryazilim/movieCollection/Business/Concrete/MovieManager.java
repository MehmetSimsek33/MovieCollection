package ozguryazilim.movieCollection.Business.Concrete;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ozguryazilim.movieCollection.Business.Abstract.MovieService;
import ozguryazilim.movieCollection.DataAccess.Abstact.ActorRepository;
import ozguryazilim.movieCollection.DataAccess.Abstact.MovieRepository;
import ozguryazilim.movieCollection.Entities.Concrete.Actor;
import ozguryazilim.movieCollection.Entities.Concrete.Movie;

@Service
public class MovieManager implements MovieService {

	@Autowired
	private MovieRepository _movieRepository;
	
	@Autowired
	ActorRepository actorRepository;
	

	@Override
	public List<Movie> getAllMovie() {
		// TODO Auto-generated method stub
		
		return _movieRepository.findAll();
	}



	@Override
	public void addMovie(Movie movie) {
			
		_movieRepository.save(movie);
		
	}





	@Override
	public Movie getMovieById(long id) {
		Optional<Movie> optional = _movieRepository.findById(id);
		Movie movie = null;
		if (optional.isPresent()) {
			movie = optional.get();
		} 
		else {
			throw new RuntimeException("Id ye ait film bulunamadi ::" + id);
		}
		return movie;
	}



	@Override
	public void deleteMovie(long id) {
		this._movieRepository.deleteById(id);
		
	}



	@Override
	public Page<Movie> findPaginated(int pageNo, int pageSize,String sortField,String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();
		Pageable pageable=PageRequest.of(pageNo-1,pageSize,sort);
		return this._movieRepository.findAll(pageable);
	}



	@Override
	public List<Movie> getByKeyword(String keyword) {
		// TODO Auto-generated method stub
		List<Movie> seachMovie = _movieRepository.findMoviesByKeyword(keyword);
		return seachMovie;
	}

}
