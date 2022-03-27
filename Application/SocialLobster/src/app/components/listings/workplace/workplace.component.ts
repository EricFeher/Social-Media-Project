import { Component, OnInit } from '@angular/core';
import { WorkplaceService } from 'src/app/services/workplace.service';

@Component({
  selector: 'app-workplace',
  templateUrl: './workplace.component.html',
  styleUrls: ['./workplace.component.scss']
})
export class WorkplaceComponent implements OnInit {

 
 
  workplace: any[];
  constructor(private workplaceService: WorkplaceService) { }

  ngOnInit(): void {
    this.retrieveUserData();
  }

  retrieveUserData(): void{
    this.workplaceService.getAll()
    .subscribe(
      data => {
        console.log(data);
        this.workplace = data;
      }
    );
  }
}
