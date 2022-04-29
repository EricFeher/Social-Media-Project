import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/shared/models/post.model';
import { User } from 'src/app/shared/models/user.model';
import { PostService } from 'src/app/shared/services/post.service';
import { UserService } from '../../shared/services/user.service';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.scss']
})
export class FeedComponent implements OnInit {
  users: User[]
  posts: Post[]
  constructor(private userService: UserService, private postService: PostService) { }

  ngOnInit(): void {
    this.getAllPost();
  }

  getAllPost(){
    this.postService.getAll().subscribe(data => {
      this.posts = data;
      this.getUsersById();
    }, error => {
      console.log("Error to get posts!");
    });
  }

  getUsersById() {
    for (let i = 0; i < this.posts.length; i++){
     const items= this.userService.getOneById(this.posts[i].user_id).subscribe(data => {
       items.unsubscribe();
        this.users.push(data as User);
      }, error=>{
          console.log("Error to get one user from database.");
      });
    }
  }

}
