import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/shared/models/post.model';
import { PostService } from 'src/app/shared/services/post.service';
import {Comments} from "../../../../shared/models/comments.model";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-post-list',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.scss']
})
export class PostComponent implements OnInit {

  post = new Post();
  posts: any[];
  constructor(private postService: PostService) { }

  ngOnInit(): void {
    this.retrieveUserData();
  }

  retrieveUserData(): void{
    this.postService.getAll()
    .subscribe(
      data => {
        console.log(data);
        this.posts = data;
      }
    );
  }

  sendPost(): void{
    this.postService.sendPostFromRemote(this.post).subscribe(
    )
    window.location.reload();
  }
  onDelete(number: number): void{
    this.postService.deleteStudent(number);
    window.location.reload();
  }



  user2 = new Post();

  userupdateform=new FormGroup({
    id:new FormControl(),
    user_id:new FormControl(),
    creation_time:new FormControl(),
    content:new FormControl()
  });


  changeisUpdate() {
    this.user2=new Post();
    this.user2.id=this.userupdateform.get('id')?.value
    this.user2.user_id=this.userupdateform.get('user_id')?.value
    this.user2.creationtime=this.userupdateform.get('creation_time')?.value
    this.user2.content=this.userupdateform.get('content')?.value
    this.postService.updatePost(this.user2);
    console.log("lefute")
  }

  updateUser(user: Post) {
    this.user2=user;
  }
}

