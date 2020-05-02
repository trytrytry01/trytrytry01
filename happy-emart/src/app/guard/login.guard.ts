import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginGuard implements CanActivate {
  canActivate() {
    if (!sessionStorage.getItem('token')) {
      alert('Please Sign in')
      return false;
    } else{
      return true;
    }
  }
  
}
