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
      }
    );
  }

  retrieveUsers(): void{
    this.userService.getAll()
    .subscribe(
      data => {
        console.log(data);
        this.users = data;
      }
    );
  }


}
