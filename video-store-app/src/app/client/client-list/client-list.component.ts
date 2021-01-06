import { Component, OnInit } from '@angular/core';
import { Client } from 'src/app/models/client.model';
import { Router } from '@angular/router';
import { ClientService } from 'src/app/services/client.service';

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css']
})
export class ClientListComponent implements OnInit {

  clients: Client[] = [];
  
  constructor(
    private clientService: ClientService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.loadClients();
  }

  delete(id: number) {
    this.clientService.delete(id).subscribe(result => { 
      this.loadClients();
    });
  }

  update(id: number) {
    console.log(id);
    this.router.navigate(['/editClient/' + id]);
  }

  loadClients(){
    this.clientService.list().subscribe(result => {
      this.clients = result
      console.log(result);
    });
  }
}
