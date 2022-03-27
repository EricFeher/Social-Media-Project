import { Component, OnInit } from '@angular/core';
import { PhotosService } from 'src/app/services/photos.service';

@Component({
  selector: 'app-photos-list',
  templateUrl: './photos.component.html',
  styleUrls: ['./photos.component.scss']
})
export class PhotosComponent implements OnInit {


 
  photos: any[];
  constructor(private photoService: PhotosService) { }

  ngOnInit(): void {
    this.retrieveUserData();
  }

  retrieveUserData(): void{
    this.photoService.getAll()
    .subscribe(
      data => {
        console.log(data);
        this.photos = data;
      }
    );
  }
}