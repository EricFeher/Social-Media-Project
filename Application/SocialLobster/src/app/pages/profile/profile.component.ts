import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/shared/models/user.model';
import { UserService } from '../../shared/services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  user: User
  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.getOneUserById();
  }

  getOneUserById() {
    const user = JSON.parse(localStorage.getItem('user') as string);
    this.userService.getOneById(user.id).subscribe(data => {
      this.user = data;
      
    }, error=>{
        console.log("Error to get one user from database.");
        
    });

  }

}
