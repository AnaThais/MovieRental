import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { HttpClientModule } from '@angular/common/http';
import { ClientListComponent } from './client/client-list/client-list.component';
import { ClientFormComponent } from './client/client-form/client-form.component';
import { MovieListComponent } from './movie/movie-list/movie-list.component';
import { MovieFormComponent } from './movie/movie-form/movie-form.component';
import { RegisterListComponent } from './register/register-list/register-list.component';
import { RegisterFormComponent } from './register/register-form/register-form.component';
import { ClientService } from './services/client.service';
import { MovieService } from './services/movie.service';
import { FooterComponent } from './footer/footer.component';
import { MovieRentComponent } from './movie/movie-rent/movie-rent.component';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    ClientListComponent,
    ClientFormComponent,
    MovieListComponent,
    MovieFormComponent,
    RegisterListComponent,
    RegisterFormComponent,
    FooterComponent,
    MovieRentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    BsDropdownModule.forRoot()
  ],
  providers: [ ClientService, MovieService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
