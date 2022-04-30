import { Component, OnInit } from '@angular/core';
import { UserData } from 'src/app/shared/models/userdata.model';
import { UserdataService } from 'src/app/shared/services/userdata.service';

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

}
