package video.store.controller;

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
import video.store.service.MovieService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path = "/v1/movie")
public class MovieController {

	@Autowired
	MovieService movieService;

	@PostMapping(path = "/addMovie")
	public @ResponseBody void addMovie(@RequestBody final Movie movie) {

		movieService.addMovie(movie);
	}

	@GetMapping(path = "/findById/{id}")
	public @ResponseBody Movie findById(@PathVariable final Integer id) {

		return movieService.findById(id);
	}

	@GetMapping(path = "/findByGenre/{genre}")
	public @ResponseBody List<Movie> findByGenre(@PathVariable final String genre) {

		return movieService.findByGenre(genre);
	}

	@GetMapping(path = "/findAll")
	public @ResponseBody Iterable<Movie> findAll() {

		return movieService.findAll();
	}

	@PutMapping(path = "/updateMovie")
	public @ResponseBody void updateMovie(@RequestBody final Movie movie) {

		movieService.updateMovie(movie);
	}

	@DeleteMapping(path = "/deleteMovie/{id}")
	public @ResponseBody void deleteMovie(@PathVariable final Integer id) {

		movieService.deleteMovie(id);
	}
}
