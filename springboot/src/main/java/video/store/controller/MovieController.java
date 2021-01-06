package video.store.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import video.store.model.Movie;
import video.store.model.Register;
import video.store.repository.MovieRepository;
import video.store.repository.RegisterRepository;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path = "/v1/movie")
public class MovieController {

	@Autowired
	MovieRepository repo;

	@Autowired
	RegisterRepository registerRepo;

	@PostMapping(path = "/addMovie")
	public @ResponseBody void addMovie(@RequestBody final Movie movie) {

		movie.setIsAvailable(true);
		repo.save(movie);
	}

	@GetMapping(path = "/findById/{id}")
	public @ResponseBody Movie findById(@PathVariable final Integer id) {

		return repo.findById(id).get();
	}

	@GetMapping(path = "/findByGenre/{genre}")
	public @ResponseBody List<Movie> findByGenre(@PathVariable final String genre) {

		return repo.findByGenre(genre);
	}

	@GetMapping(path = "/findAll")
	public @ResponseBody Iterable<Movie> findAll() {

		final Iterable<Movie> movies = repo.findAll();
		if (movies != null) {
			movies.forEach(movie -> {

				if (!movie.getIsAvailable()) {

					final List<Register> registers = registerRepo.findByMovie(movie);
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

	@PutMapping(path = "/updateMovie")
	public @ResponseBody void updateMovie(@RequestBody final Movie movie) {

		repo.save(movie);
	}

	@DeleteMapping(path = "/deleteMovie/{id}")
	public @ResponseBody void deleteMovie(@PathVariable final Integer id) {

		repo.deleteById(id);
	}

}
