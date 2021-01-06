import { Component, OnInit } from '@angular/core';
import { Movie } from 'src/app/models/movie.model';
import { MovieService } from 'src/app/services/movie.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  movies: Movie[] = [];
  search: string = "";
  movie = new Movie;
  
  private auxMovies: Movie[] = [];

  constructor(    
    private movieService: MovieService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.loadMovies();
  }

  delete(id: number) {
    this.movieService.delete(id).subscribe(result => { 
      this.loadMovies();
    });
  }

  update(id: number) {
    console.log(id);
    this.router.navigate(['/editMovie/' + id]);
  }

  public loadMovies(){
    this.movieService.list().subscribe(result => {
      this.movies = result
      console.log(this.movies);
    });
  }

  doSearch(){
    if(this.search){
      this.movieService.search(this.search).subscribe(result => { 
      this.movies = result;
     });
    } else {
      this.loadMovies();
    }
  }

  rent(id: number) {
    this.router.navigate(['/rentMovie/' + id]);
  }

  listRentalMovie() {
    this.auxMovies = [];

    this.movies.forEach(value => {
      if(!value.isAvailable) {
        this.auxMovies.push(value);
      }
    });

    this.movies = null;
    this.movies = this.auxMovies;
  }
}
