import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/shared/models/user.model';
import { RegistrationService } from 'src/app/registration.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

user = new User();
msg='';

  constructor(private _service : RegistrationService, private _router : Router) { }

  ngOnInit(): void {
  }

  registerUser(){
    this._service.registerUserFromRemote(this.user).subscribe(
      data=>{
        console.log("response reveived");
        this._router.navigate(['/login']);
      },
      error => {
        console.log("exception occured");
        this.msg=error.error;
      }
    )
  }

}
