package video.store.repository;

import org.springframework.data.repository.CrudRepository;

import video.store.model.Client;

public interface ClientRepository extends CrudRepository<Client, Integer> {

}
