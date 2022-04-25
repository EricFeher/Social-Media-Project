import { Component, OnInit } from '@angular/core';
import { UserData } from 'src/app/models/userdata.model';
import { UserdataService } from 'src/app/services/userdata.service';

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
}
