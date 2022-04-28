import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { RegistrationService } from 'src/app/registration.service';
import { User } from 'src/app/shared/models/user.model';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  user = new User();
  msg = '';

  constructor( private _service : RegistrationService, private _router : Router) { }

  ngOnInit(): void {
  }

  loginUser(){
    this._service.loginUserFromRemote(this.user).subscribe(
      data => {
        console.log("response received");
        localStorage.setItem('user', JSON.stringify(data));
        this._router.navigate(['/feed']);
      },
      error => {
        console.log("exception occured");
      this.msg = "Nem megfelelő felhasználónév vagy jelszó!";
      }
    );
  }


}
