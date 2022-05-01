import { Component, OnInit } from '@angular/core';
import { Message } from 'src/app/shared/models/message.model';
import { MessageService } from 'src/app/shared/services/message.service';
import {Comments} from "../../../../shared/models/comments.model";
import {FormControl, FormGroup} from "@angular/forms";

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


  user2 = new Message();

  userupdateform=new FormGroup({
    id:new FormControl(),
    user_id1:new FormControl(),
    user_id2:new FormControl(),
    creation_time:new FormControl(),
    content:new FormControl()
  });


  changeisUpdate() {
    this.user2=new Message();
    this.user2.id=this.userupdateform.get('id')?.value
    this.user2.user_id1=this.userupdateform.get('user_id1')?.value
    this.user2.user_id2=this.userupdateform.get('user_id2')?.value
    this.user2.content=this.userupdateform.get('content')?.value
    this.user2.creationtime=this.userupdateform.get('creation_time')?.value
    this.messageService.updateMessage(this.user2);
    console.log("lefute")
  }

  updateUser(user: Message) {
    this.user2=user;
  }
}
