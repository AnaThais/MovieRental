import { Component, OnInit } from '@angular/core';
import { Movie } from 'src/app/models/movie.model';
import { MovieService } from 'src/app/services/movie.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-movie-form',
  templateUrl: './movie-form.component.html',
  styleUrls: ['./movie-form.component.css']
})
export class MovieFormComponent implements OnInit {

  movie = new Movie;
  isEdit = false;

  constructor(
    private movieService: MovieService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe(result => {     
      if(result.id){
        this.isEdit = true;
        this.getMovie(result.id);
      }
    });
  }
  getMovie(id: number) {
    this.movieService.findById(id).subscribe(result => {
      this.movie = result;
    });
  }

  updateOrCreate() {
    console.log(this.movie);
    if(!this.isEdit){
      this.movieService.create(this.movie).subscribe(result => { 
        this.movie = new Movie;
        console.log(result);
      });
    } else {
      this.movieService.update(this.movie).subscribe(result => { 
        this.router.navigate(['/movies']);
        console.log(result);
      });
    }  
  }

}
