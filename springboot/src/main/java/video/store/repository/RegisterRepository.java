package video.store.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import video.store.model.Movie;
import video.store.model.Register;

public interface RegisterRepository extends CrudRepository<Register, Integer> {

	public List<Register> findByMovie(Movie movie);
}
