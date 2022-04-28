import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar2',
  templateUrl: './navbar2.component.html',
  styleUrls: ['./navbar2.component.scss']
})
export class Navbar2Component implements OnInit {

  loggedInUser=false;

  constructor() { }
  ngOnInit(): void {
  }

  getUserLoggedIn(){
    const user = JSON.parse(localStorage.getItem('user') as string);
    if(user){
      this.loggedInUser=true;
    }
    else{
      localStorage.setItem('user', JSON.stringify(null));
      this.loggedInUser=false;
    }
  }

}
