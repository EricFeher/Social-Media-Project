import { Component, OnInit } from '@angular/core';
import { LocationService } from 'src/app/services/location.service';

@Component({
  selector: 'app-location-list',
  templateUrl: './location.component.html',
  styleUrls: ['./location.component.scss']
})
export class LocationComponent implements OnInit {

  location: any[];
  constructor(private locationService: LocationService) { }

  ngOnInit(): void {
    this.retrieveUserData();
  }

  retrieveUserData(): void{
    this.locationService.getAll()
    .subscribe(
      data => {
        console.log(data);
        this.location = data;
      }
    );
  }
}
