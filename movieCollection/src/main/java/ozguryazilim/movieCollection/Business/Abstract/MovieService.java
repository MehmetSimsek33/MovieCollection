package ozguryazilim.movieCollection.Business.Abstract;

import java.util.List;

import org.springframework.data.domain.Page;

import ozguryazilim.movieCollection.Entities.Concrete.Movie;

public interface MovieService {
	
	void addMovie(Movie movie);
	void deleteMovie(long id);
	Movie getMovieById(long id);
	List<Movie> getAllMovie();
	Page<Movie> findPaginated(int pageNo,int pageSize,String sortField,String sortDirection);
	List<Movie> getByKeyword(String keyword);
}
	
