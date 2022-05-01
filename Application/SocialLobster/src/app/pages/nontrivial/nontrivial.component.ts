import { Component, OnInit } from '@angular/core';
import { Location } from 'src/app/shared/models/location.model';
import { User } from 'src/app/shared/models/user.model';
import { UserData } from 'src/app/shared/models/userdata.model';
import { NontrivialService } from 'src/app/shared/services/nontrivial.service';

@Component({
  selector: 'app-nontrivial',
  templateUrl: './nontrivial.component.html',
  styleUrls: ['./nontrivial.component.scss']
})
export class NontrivialComponent implements OnInit {
  schoolLocation: Location[]
  users: UserData[]
  user: User[]
  constructor(private nonTrivialService: NontrivialService) { }

  ngOnInit(): void {
    this.getSchoolLocation();
    this.getUser3Follower();
    this.getUserWhoWritePost();
    
  }

  getSchoolLocation() {
    this.nonTrivialService.getSchoolLocation().subscribe(data => {
      this.schoolLocation=data;  
    }, error => {
      console.log("error");
    })
  }

  getUser3Follower() {
    this.nonTrivialService.getUserWhere3Followers().subscribe(data => {
      console.log(data);
      
      this.users=data;
    }, error => {
      console.log("Error");
    })
  }

  getUserWhoWritePost() {
    this.nonTrivialService.getUserWhoWritePost().subscribe(data => {
      console.log(data);
      this.user = data;
    }, error => {
      console.log("Error");
    })
  }

}
