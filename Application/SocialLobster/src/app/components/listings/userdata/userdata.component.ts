import { Component, OnInit } from '@angular/core';
import { UserdataService } from 'src/app/services/userdata.service';

@Component({
  selector: 'app-userdata',
  templateUrl: './userdata.component.html',
  styleUrls: ['./userdata.component.scss']
})
export class UserdataComponent implements OnInit {

 
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
}
