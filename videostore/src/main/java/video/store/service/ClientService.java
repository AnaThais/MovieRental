package video.store.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import video.store.model.Client;
import video.store.model.Movie;
import video.store.model.Register;
import video.store.repository.ClientRepository;
import video.store.repository.MovieRepository;
import video.store.repository.RegisterRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	RegisterRepository registerRepository;

	@Autowired
	MovieRepository movieRepository;

	public void addClient(final Client client) {

		clientRepository.save(client);
	}

	public Client findById(final Integer id) {

		if (clientRepository.findById(id).isPresent()) {
			return clientRepository.findById(id).get();
		}

		return null;
	}

	public List<Client> findAll() {

		return (List<Client>) clientRepository.findAll();
	}

	public void updateClient(final Client client) {

		clientRepository.save(client);
	}

	public void deleteClient(final Integer id) {

		final Client client = new Client();
		client.setId(id);

		final List<Register> registers = registerRepository.findByClient(client);
		if (registers != null) {
			registers.forEach(register -> {
				final Date currentDate = new Date();

				if (register.getEndDate().after(currentDate)) {
					final Optional<Movie> movie = movieRepository.findById(register.getMovie().getId());
					if (movie.isPresent()) {
						movie.get().setIsAvailable(true);

						movieRepository.save(movie.get());
					}
				}
			});
		}

		clientRepository.deleteById(id);
	}
}
