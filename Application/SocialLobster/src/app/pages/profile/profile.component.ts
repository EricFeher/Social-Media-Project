import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/shared/models/user.model';
import { UserData } from 'src/app/shared/models/userdata.model';
import { UserdataService } from 'src/app/shared/services/userdata.service';
import { UserService } from '../../shared/services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  user: User
  userDatas: UserData[]
  isUserData: boolean
  constructor(private userService: UserService, private userDataService: UserdataService) { }

  ngOnInit(): void {
    this.getOneUserById();
    this.getOneUserData();
  }

  getOneUserById() {
    const user = JSON.parse(localStorage.getItem('user') as string);
    this.userService.getOneById(user.id).subscribe(data => {
    this.user = data;
      
    }, error=>{
        console.log("Error to get one user from database.");
    });

  }

  getOneUserData() {
    const user = JSON.parse(localStorage.getItem('user') as string);
    this.userDataService.getOneByUserId(user.id).subscribe(data => {
      this.userDatas = data;
      this.isUserDataOnDatabase();
    }, error=> {
      console.log("Error to get one userdata from database.");
    })
  }

  isUserDataOnDatabase(){
    if(this.userDatas.length == 0){
      this.isUserData = false;
    } else {
      this.isUserData = true;
    }
  }

}
