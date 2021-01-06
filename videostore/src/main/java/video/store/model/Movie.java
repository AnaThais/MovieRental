package video.store.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String title;
	private String year;
	private String director;
	private String genre;
	private Boolean isAvailable;

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(final String year) {
		this.year = year;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(final String director) {
		this.director = director;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(final String genre) {
		this.genre = genre;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(final Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
}
