import { Component, OnInit } from '@angular/core';
import { MessageService } from 'src/app/services/message.service';

@Component({
  selector: 'app-message-list',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.scss']
})
export class MessageComponent implements OnInit {

 
 
  messages: any[];
  constructor(private messageService: MessageService) { }

  ngOnInit(): void {
    this.retrieveUserData();
  }

  retrieveUserData(): void{
    this.messageService.getAll()
    .subscribe(
      data => {
        console.log(data);
        this.messages = data;
      }
    );
  }
}
