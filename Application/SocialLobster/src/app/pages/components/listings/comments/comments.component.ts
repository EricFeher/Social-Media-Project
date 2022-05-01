import { Component, OnInit } from '@angular/core';
import { Comments } from 'src/app/shared/models/comments.model';
import { CommentsService } from 'src/app/shared/services/comments.service';
import {User} from "../../../../shared/models/user.model";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-comments-list',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.scss']
})
export class CommentsComponent implements OnInit {

  comments: any[];
  comment = new Comments();
  constructor(private commentService: CommentsService) { }

  ngOnInit(): void {
    this.retrieveSchools();
  }

  retrieveSchools(): void{
    this.commentService.getAll()
    .subscribe(
      data => {
        console.log(data);
        this.comments = data;
      }
    );
  }

  sendComment(): void{
    this.commentService.sendCommentFromRemote(this.comment).subscribe(
    )
    window.location.reload();
  }

  onDelete(number: number): void{
    this.commentService.deleteStudent(number);
    window.location.reload();
  }


  user2 = new Comments();

  userupdateform=new FormGroup({
    id:new FormControl(),
    user_id:new FormControl(),
    post_id:new FormControl(),
    creation_time:new FormControl(),
    content:new FormControl()
  });


  changeisUpdate() {
    this.user2=new Comments();
    this.user2.id=this.userupdateform.get('id')?.value
    this.user2.user_id=this.userupdateform.get('user_id')?.value
    this.user2.post_id=this.userupdateform.get('post_id')?.value
    this.user2.creationtime=this.userupdateform.get('creation_time')?.value
    this.user2.content=this.userupdateform.get('content')?.value
    this.commentService.updateComment(this.user2);
    console.log("lefute")
  }

  updateUser(user: Comments) {
    this.user2=user;
  }

}
