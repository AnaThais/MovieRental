import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Movie } from '../models/movie.model';

@Injectable({
  providedIn: 'root'
})

export class MovieService {

  private baseUrl = 'http://localhost:8080/v1/movie'; 

  constructor(
    private http: HttpClient
  ) { }

  list() {
    return this.http.get<Movie[]>(this.baseUrl + '/findAll');
  } 

  update(movie: Movie) {
    return this.http.put<string>(this.baseUrl + '/updateMovie', movie);
  } 

  delete(id: number) {
    return this.http.delete<any>(this.baseUrl + '/deleteMovie/' + id);
  } 

  findById(id: number) {
    return this.http.get<Movie>(this.baseUrl + '/findById/' + id);
  }

  create(movie: Movie) {
    return this.http.post<any>(this.baseUrl + '/addMovie', movie);
  }

  search(query: string) {
    return this.http.get<Movie[]>(this.baseUrl + '/findByGenre/' + query);
  }
}
