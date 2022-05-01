import { Component, OnInit } from '@angular/core';
import { Photos } from 'src/app/shared/models/photos.model';
import { PhotosService } from 'src/app/shared/services/photos.service';
import {Comments} from "../../../../shared/models/comments.model";
import {FormControl, FormGroup} from "@angular/forms";

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


  user2 = new Photos();

  userupdateform=new FormGroup({
    id:new FormControl(),
    user_id:new FormControl(),
    photo:new FormControl()
  });


  changeisUpdate() {
    this.user2=new Photos();
    this.user2.id=this.userupdateform.get('id')?.value
    this.user2.user_id=this.userupdateform.get('user_id')?.value
    this.user2.photo=this.userupdateform.get('photo')?.value
    this.photoService.updatePhoto(this.user2);
    console.log("lefute")
  }

  updateUser(user: Photos) {
    this.user2=user;
  }
}
