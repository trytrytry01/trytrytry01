import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import {UserService} from '../services/user.service';

@Injectable({
  providedIn: 'root'
})
export class LoginGuard implements CanActivate {

  constructor(protected userService: UserService) {}

  canActivate() {
    // return this.userService.isBuyerLogged();
    if (!sessionStorage.getItem('token')) {
      alert('Please Sign in')
      return false;
    } else{
      return true;
    }
  }
  
}
