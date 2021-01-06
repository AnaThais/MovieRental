import { Component, OnInit } from '@angular/core';
import { Register } from 'src/app/models/register.model';
import { RegisterService } from 'src/app/services/register.service';

@Component({
  selector: 'app-register-list',
  templateUrl: './register-list.component.html',
  styleUrls: ['./register-list.component.css']
})
export class RegisterListComponent implements OnInit {

  registers: Register[] = [];
  isEmpty = true;
  constructor(
    private registerService: RegisterService
  ) { }

  ngOnInit(): void {
    this.loadRegister();
  }

  loadRegister(){
    this.registerService.list().subscribe(result => {
      this.registers = result
      if(this.registers.length > 0){
        this.isEmpty = false;
      }
      else{
        this.isEmpty = true;
      }
    });
  }
}
