import { Component, OnInit } from '@angular/core';
import { CommentsService } from 'src/app/services/comments.service';

@Component({
  selector: 'app-comments-list',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.scss']
})
export class CommentsComponent implements OnInit {

  comments: any[];
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

}
