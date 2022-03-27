import { Component, OnInit } from '@angular/core';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-post-list',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.scss']
})
export class PostComponent implements OnInit {

 
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
}

