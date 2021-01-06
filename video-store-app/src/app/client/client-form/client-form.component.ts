import { Component, OnInit } from '@angular/core';
import { Client } from 'src/app/models/client.model';
import { ClientService } from 'src/app/services/client.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-client-form',
  templateUrl: './client-form.component.html',
  styleUrls: ['./client-form.component.css']
})
export class ClientFormComponent implements OnInit {

  client = new Client;
  isEdit = false;

  constructor(
    private clientService: ClientService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe(result => {     
      if(result.id){
        this.isEdit = true;
        this.getClient(result.id);
      }
    });
  }

  getClient(id: number) {
    this.clientService.findById(id).subscribe(result => {
      this.client = result;
    });
  }

  updateOrCreate() {
    console.log(this.client);
    if(!this.isEdit){
      this.clientService.create(this.client).subscribe(result => { 
        this.client = new Client;
        console.log(result);
      });
    } else {
      this.clientService.update(this.client).subscribe(result => { 
        this.router.navigate(['/clients']);
        console.log(result);
      });
    }  
  }
}
