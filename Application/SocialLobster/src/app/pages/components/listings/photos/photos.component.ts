import { Component, OnInit } from '@angular/core';
import { Photos } from 'src/app/shared/models/photos.model';
import { PhotosService } from 'src/app/shared/services/photos.service';

@Component({
  selector: 'app-photos-list',
  templateUrl: './photos.component.html',
  styleUrls: ['./photos.component.scss']
})
export class PhotosComponent implements OnInit {



  photos: any[];
  photo = new Photos();
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

  sendPhoto(): void{
    this.photoService.sendPhotoFromRemote(this.photo).subscribe(
    )
    window.location.reload();
  }
  onDelete(number: number): void{
    this.photoService.deleteStudent(number);
    window.location.reload();
  }

}
