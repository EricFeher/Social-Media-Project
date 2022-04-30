import { Component, OnInit } from '@angular/core';
import { Message } from 'src/app/shared/models/message.model';
import { MessageService } from 'src/app/shared/services/message.service';

@Component({
  selector: 'app-message-list',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.scss']
})
export class MessageComponent implements OnInit {


  message = new Message();
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

  sendMessage(): void{
    this.messageService.sendMessageFromRemote(this.message).subscribe(
    )
    window.location.reload();
  }
  onDelete(number: number): void{
    this.messageService.deleteStudent(number);
    window.location.reload();
  }

}
