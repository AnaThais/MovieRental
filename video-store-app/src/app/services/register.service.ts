import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Register } from '../models/register.model';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  private baseUrl = 'http://localhost:8080/v1/register'; 

  constructor(
    private http: HttpClient
  ) { }

  create(register: Register) {
    return this.http.post<any>(this.baseUrl + '/addRegister', register);
  }

  list() {
    return this.http.get<Register[]>(this.baseUrl + '/findAll');
  } 
}
