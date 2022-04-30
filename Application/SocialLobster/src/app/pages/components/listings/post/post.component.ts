import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/shared/models/post.model';
import { PostService } from 'src/app/shared/services/post.service';

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

}

