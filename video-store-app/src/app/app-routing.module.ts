import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ClientListComponent } from './client/client-list/client-list.component';
import { MovieListComponent } from './movie/movie-list/movie-list.component';
import { RegisterListComponent } from './register/register-list/register-list.component';
import { ClientFormComponent } from './client/client-form/client-form.component';
import { MovieFormComponent } from './movie/movie-form/movie-form.component';
import { MovieRentComponent } from './movie/movie-rent/movie-rent.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'clients', component: ClientListComponent },
  { path: "addClient", component: ClientFormComponent },
  { path: "editClient/:id", component: ClientFormComponent },
  { path: 'movies', component: MovieListComponent },
  { path: "addMovie", component: MovieFormComponent },
  { path: "editMovie/:id", component: MovieFormComponent },
  { path: 'registers', component: RegisterListComponent },
  { path: 'rentMovie/:id', component: MovieRentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }