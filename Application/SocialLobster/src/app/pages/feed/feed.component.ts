import { Component, OnInit } from '@angular/core';
import { Comments } from 'src/app/shared/models/comments.model';
import { Post } from 'src/app/shared/models/post.model';
import { User } from 'src/app/shared/models/user.model';
import { CommentsService } from 'src/app/shared/services/comments.service';
import { PostService } from 'src/app/shared/services/post.service';
import { UserService } from '../../shared/services/user.service';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.scss']
})
export class FeedComponent implements OnInit {
  users: Array<User> = []
  posts: Post[]
  comments: Array<any[]> = []
  user: Array<User> = []
  size: any
  
  constructor(private userService: UserService, private postService: PostService, private commentService: CommentsService) { }

  ngOnInit(): void {
    this.getAllPost();
    let size = this.posts.length;
  }

  getAllPost(){
   const items = this.postService.getAll().subscribe(data => {
    items.unsubscribe();
      this.posts = data;
      this.getUsersById();
      this.getComments();
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

  getComments() {
    for (let i = 0; i < this.posts.length; i++){
      this.commentService.selectComments(this.posts[i].id).subscribe(data => {
        this.comments.push(data)
      }, error =>{
        console.log("Error");
      })
    } 
  }

  /*getCommentsUser() {
    this.commentService.selectUserForComments(id).subscribe(data => {
      this.user = data;
    }, error => {
      console.log("Error");
    })
  }*/

}
