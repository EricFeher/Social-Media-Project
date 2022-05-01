import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/shared/models/user.model';
import { UserService } from 'src/app/shared/services/user.service';
import { Router } from '@angular/router';
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {
  users: any[];
  user = new User();
  user2 = new User();
  msg='';

  userupdateform=new FormGroup({
    id:new FormControl(),
    username:new FormControl(),
    password:new FormControl(),
    email:new FormControl()
  });


  constructor(private _service: UserService, private _router : Router) { }

  ngOnInit(): void {
    this.retrieveUsers();
  }

  retrieveUsers(): void{
    this._service.getAll()
    .subscribe(
      data => {
        console.log(data);
        this.users = data;
      }
    );
  }

  sendUser(): void{
    this._service.sendUserFromRemote(this.user).subscribe(
    )
    window.location.reload();
  }
  onDelete(number: number): void{
    this._service.deleteStudent(number);
    window.location.reload();
  }


  changeisUpdate() {
    this.user2=new User();
    this.user2.username=this.userupdateform.get('username')?.value
    this.user2.email=this.userupdateform.get('email')?.value
    this.user2.id=this.userupdateform.get('id')?.value
    this.user2.password=this.userupdateform.get('password')?.value
    this._service.updateStudent(this.user2);
    console.log("lefute")
  }

  updateUser(user: User) {
    this.user2=user;
  }
}
