import { Component, OnInit } from '@angular/core';
import { Workplace } from 'src/app/models/workplace.model';
import { WorkplaceService } from 'src/app/services/workplace.service';

@Component({
  selector: 'app-workplace-list',
  templateUrl: './workplace.component.html',
  styleUrls: ['./workplace.component.scss']
})
export class WorkplaceComponent implements OnInit {

 
  workplaces = new Workplace();
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

  sendWorkplace(): void{
    this.workplaceService.sendWorkplaceFromRemote(this.workplaces).subscribe(
    )
    window.location.reload();
  }

}
