import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(protected userService: UserService) { }

  ngOnInit() {
  }

  islogged() {
    return this.userService.isLogged();
  }

  isBuyerLogged() {
    return this.userService.isBuyerLogged();
  }

  isSellerLogged() {
    return this.userService.isSellerLogged();
  }

}
