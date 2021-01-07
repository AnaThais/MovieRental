package video.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import video.store.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

}
