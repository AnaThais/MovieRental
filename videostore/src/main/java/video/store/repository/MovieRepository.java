package video.store.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import video.store.model.Movie;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

	public List<Movie> findByGenre(String genre);

}
