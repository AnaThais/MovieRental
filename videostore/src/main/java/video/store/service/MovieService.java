package video.store.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import video.store.model.Movie;
import video.store.model.Register;
import video.store.repository.MovieRepository;
import video.store.repository.RegisterRepository;

@Service
public class MovieService {

	@Autowired
	MovieRepository movieRepository;

	@Autowired
	RegisterRepository registerRepository;

	public void addMovie(final Movie movie) {

		movie.setIsAvailable(true);
		movieRepository.save(movie);
	}

	public Movie findById(final Integer id) {

		return movieRepository.findById(id).get();
	}

	public List<Movie> findByGenre(final String genre) {

		return movieRepository.findByGenre(genre);
	}

	public Iterable<Movie> findAll() {

		final Iterable<Movie> movies = movieRepository.findAll();
		if (movies != null) {
			movies.forEach(movie -> {

				if (!movie.getIsAvailable()) {

					final List<Register> registers = registerRepository.findByMovie(movie);
					if (registers != null) {

						registers.forEach(register -> {
							final Date currentDate = new Date();

							if (register.getEndDate().before(currentDate)) {
								movie.setIsAvailable(true);
							}
						});
					}
				}
			});
		}

		return movies;
	}

	public void updateMovie(final Movie movie) {

		movieRepository.save(movie);
	}

	public void deleteMovie(final Integer id) {

		movieRepository.deleteById(id);
	}
}
