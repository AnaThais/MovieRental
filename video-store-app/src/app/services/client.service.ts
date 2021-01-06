import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Client } from '../models/client.model';

@Injectable({
  providedIn: 'root'
})

export class ClientService {
  
  private baseUrl = 'http://localhost:8080/v1/client';

  constructor(
    private http: HttpClient
  ) { }

  list() {
    return this.http.get<Client[]>(this.baseUrl + '/findAll');
  }

  delete(id: number) {
    return this.http.delete<any>(this.baseUrl + '/deleteClient/' + id);
  }
  
  findById(id: number) {
    return this.http.get<Client>(this.baseUrl + '/findById/' + id);
  }

  create(client: Client) {
    return this.http.post<any>(this.baseUrl + '/addClient', client);
  }

  update(client: Client) {
    return this.http.put<string>(this.baseUrl + '/updateClient', client);
  }
}
