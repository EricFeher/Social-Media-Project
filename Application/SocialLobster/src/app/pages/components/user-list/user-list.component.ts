import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/shared/models/user.model';
import { UserService } from 'src/app/shared/services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {
  users: any[];
  user = new User();
  msg='';

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

}
