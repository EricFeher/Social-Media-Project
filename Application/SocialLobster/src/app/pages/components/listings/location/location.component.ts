import { Component, OnInit } from '@angular/core';
import { Location } from 'src/app/shared/models/location.model';
import { LocationService } from 'src/app/shared/services/location.service';
import {Comments} from "../../../../shared/models/comments.model";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-location-list',
  templateUrl: './location.component.html',
  styleUrls: ['./location.component.scss']
})
export class LocationComponent implements OnInit {

  location = new Location();
  locations: any[];
  constructor(private locationService: LocationService) { }

  ngOnInit(): void {
    this.retrieveUserData();
  }

  retrieveUserData(): void{
    this.locationService.getAll()
    .subscribe(
      data => {
        console.log(data);
        this.locations = data;
      }
    );
  }

  sendLocation(): void{
    this.locationService.sendLocationFromRemote(this.location).subscribe(

    )
  window.location.reload();
  }
  onDelete(number: number): void{
    this.locationService.deleteStudent(number);
    window.location.reload();
  }

  user2 = new Location();

  userupdateform=new FormGroup({
    id:new FormControl(),
    postcode:new FormControl(),
    city:new FormControl(),
    street:new FormControl(),
    housenumber:new FormControl()
  });


  changeisUpdate() {
    this.user2=new Location();
    this.user2.id=this.userupdateform.get('id')?.value
    this.user2.postcode=this.userupdateform.get('postcode')?.value
    this.user2.city=this.userupdateform.get('city')?.value
    this.user2.street=this.userupdateform.get('street')?.value
    this.user2.housenumber=this.userupdateform.get('housenumber')?.value
    this.locationService.updateLocation(this.user2);
    console.log("lefute")
  }

  updateUser(user: Location) {
    this.user2=user;
  }

}
