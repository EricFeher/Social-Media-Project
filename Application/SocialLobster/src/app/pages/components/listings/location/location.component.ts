import { Component, OnInit } from '@angular/core';
import { Location } from 'src/app/shared/models/location.model';
import { LocationService } from 'src/app/shared/services/location.service';

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

}
