import { Component, OnInit } from '@angular/core';
import { Location } from 'src/app/shared/models/location.model';
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
  constructor(private nonTrivialService: NontrivialService) { }

  ngOnInit(): void {
    this.getSchoolLocation();
    this.getUser3Follower();
    
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

}
