import { Component, OnInit } from '@angular/core';
import { Movie } from 'src/app/models/movie.model';
import { MovieService } from 'src/app/services/movie.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Client } from 'src/app/models/client.model';
import { ClientService } from 'src/app/services/client.service';
import { BsDropdownConfig } from 'ngx-bootstrap/dropdown';
import { NgbModalConfig, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { RegisterService } from 'src/app/services/register.service';
import { Register } from 'src/app/models/register.model';

@Component({
  selector: 'app-movie-rent',
  templateUrl: './movie-rent.component.html',
  styleUrls: ['./movie-rent.component.css'],
  providers: [{ provide: BsDropdownConfig, useValue: { isAnimated: true, autoClose: true } }]
})
export class MovieRentComponent implements OnInit {

  movie = new Movie;
  clients: Client[] = [];
  dateString: string;
  register = new Register;
  isAvailable = true;
  
    constructor(    
      private movieService: MovieService,
      private clientService: ClientService,
      private registerService: RegisterService,
      private route: ActivatedRoute,
      private router: Router,
      private modalService: NgbModal
    ) { }

  ngOnInit(): void {
    this.dateString = "";

    this.route.params.subscribe(result => {     
      this.movieService.findById(result.id).subscribe(result => {
        this.movie = result;
        if(this.movie.isAvailable === false) {
          this.isAvailable = false;
        }
        else {
          this.isAvailable = true;
        }
      });
    });

    this.clientService.list().subscribe(result => {
      this.clients = result;
    });
  }

  selectClient(clientId: number, movieId: number) {
    if(0 === this.dateString.length){
      return;
    }
    
    this.register.client = new Client;
    this.register.client.id = clientId;
    this.register.movie = new Movie;
    this.register.movie.id = movieId;
    this.register.endDate = this.dateString;
    this.registerService.create(this.register).subscribe(result => {
      this.register = new Register;
    });
  
    this.movie.isAvailable = false;
    this.movieService.update(this.movie).subscribe(result => {
        console.log(result);
    });

    this.isAvailable = false;
  }

  parseDate(dateString: string): Date {
    if (dateString) {
      this.dateString = dateString;
      return new Date(dateString);
    }
    return null;
  }
  
  open(content) {
    this.modalService.open(content);
  }
}
