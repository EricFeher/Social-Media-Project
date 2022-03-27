import { Component, OnInit } from '@angular/core';
import { GroupsService } from 'src/app/services/groups.service';

@Component({
  selector: 'app-groups-list',
  templateUrl: './groups.component.html',
  styleUrls: ['./groups.component.scss']
})
export class GroupsComponent implements OnInit {

  groups: any[];
  constructor(private groupService: GroupsService) { }

  ngOnInit(): void {
    this.retrieveGroups();
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
}
