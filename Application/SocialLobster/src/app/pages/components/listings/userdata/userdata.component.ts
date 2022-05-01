import { Component, OnInit } from '@angular/core';
import { UserData } from 'src/app/shared/models/userdata.model';
import { UserdataService } from 'src/app/shared/services/userdata.service';
import {Comments} from "../../../../shared/models/comments.model";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-userdata-list',
  templateUrl: './userdata.component.html',
  styleUrls: ['./userdata.component.scss']
})
export class UserdataComponent implements OnInit {

  userdatas = new UserData();
  userdata: any[];
  constructor(private userdataService: UserdataService) { }

  ngOnInit(): void {
    this.retrieveUserData();
  }

  retrieveUserData(): void{
    this.userdataService.getAll()
    .subscribe(
      data => {
        console.log(data);
        this.userdata = data;
      }
    );
  }

  sendUserdata(): void{
    this.userdataService.sendUserdataFromRemote(this.userdatas).subscribe(
    )
    window.location.reload();
  }
  onDelete(number: number): void{
    this.userdataService.deleteStudent(number);
    window.location.reload();
  }


  user2 = new UserData();

  userupdateform=new FormGroup({
    id:new FormControl(),
    user_id:new FormControl(),
    gender:new FormControl(),
    first_name:new FormControl(),
    last_name:new FormControl(),
    birthday:new FormControl(),
    photo_id:new FormControl(),
    location_id:new FormControl()
  });


  changeisUpdate() {
    this.user2=new UserData();
    this.user2.id=this.userupdateform.get('id')?.value
    this.user2.user_id=this.userupdateform.get('user_id')?.value
    this.user2.gender=this.userupdateform.get('gender')?.value
    this.user2.first_name=this.userupdateform.get('first_name')?.value
    this.user2.last_name=this.userupdateform.get('last_name')?.value
    this.user2.birthday=this.userupdateform.get('birthday')?.value
    this.user2.location_id=this.userupdateform.get('location_id')?.value
    this.user2.photo_id=this.userupdateform.get('photo_id')?.value
    this.userdataService.updateUserData(this.user2);
    console.log("lefute")
  }

  updateUser(user: UserData) {
    this.user2=user;
  }

}
