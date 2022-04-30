import { Component, OnInit } from '@angular/core';
import { Comments } from 'src/app/shared/models/comments.model';
import { CommentsService } from 'src/app/shared/services/comments.service';

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


}
