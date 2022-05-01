import { Component, OnInit } from '@angular/core';
import { Groups } from 'src/app/shared/models/groups.model';
import { User } from 'src/app/shared/models/user.model';
import { GroupsService } from 'src/app/shared/services/groups.service';
import { UserService } from '../../shared/services/user.service';

@Component({
  selector: 'app-explore',
  templateUrl: './explore.component.html',
  styleUrls: ['./explore.component.scss']
})
export class ExploreComponent implements OnInit {
  groups: Groups[]
  users: User[]
  follows: Array<any[]> = []
  followers: Array<any[]> = []
  groupMembers: Array<any[]> = []
  groupAdmin: Array<User[]> = []
  constructor(private groupService: GroupsService, private userService: UserService) { }

  ngOnInit(): void {
    this.retrieveGroups();
    this.retrieveUsers();
  }

  retrieveGroups(): void{
    this.groupService.getAll()
    .subscribe(
      data => {
        console.log(data);
        this.groups = data;
        this.getGroupMembers();
        this.getGroupAdmin();
      }
    );
  }

  retrieveUsers(): void{
    this.userService.getAll()
    .subscribe(
      data => {
        console.log(data);
        this.users = data;
        this.getFollows();
        this.getFollowers();
      }
    );
  }

  getFollows() {
    for (let i = 0; i < this.users.length; i++){
     const items= this.userService.getFollows(this.users[i].id).subscribe(data => {
        this.follows.push(data);
        items.unsubscribe();
      }, error => {
        console.log("error");
      })
    }
  }

  getFollowers() {
    for (let i = 0; i < this.users.length; i++){
     const items= this.userService.getFollowers(this.users[i].id).subscribe(data => {
        this.followers.push(data);
        items.unsubscribe();
      }, error => {
        console.log("error");
      })
    }
  }

  getGroupMembers() {
    for(let i = 0; i < this.groups.length; i++){
      const items= this.groupService.getGroupMembers(this.groups[i].id).subscribe(data => {
        this.groupMembers.push(data);
        items.unsubscribe();
      }, error => {
        console.log(error);
      })
    }
  }

  getGroupAdmin() {
    for(let i = 0; i < this.groups.length; i++){
      const items= this.groupService.getGroupAdmin(this.groups[i].id).subscribe(data => {
        this.groupAdmin.push(data);
        console.log(this.groupAdmin[2][0].username);
        items.unsubscribe();
      }, error => {
        console.log(error);
      })
    }
  }


}
