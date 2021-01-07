package video.store.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import video.store.model.Client;
import video.store.model.Movie;
import video.store.model.Register;

@Repository
public interface RegisterRepository extends CrudRepository<Register, Integer> {

	public List<Register> findByMovie(Movie movie);

	public List<Register> findByClient(Client client);
}