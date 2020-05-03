import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../environments/environment';
import { ROUTER_CONFIGURATION } from '@angular/router';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  
  @Injectable({
    providedIn: 'root'
  })
export class UserService {

    constructor(private http: HttpClient) { }

    public get currentUserToken(): string {
      return sessionStorage.getItem('token');
    }

    postSignIn(user) {
      return this.http.post(`${environment.baseUrl}/login`, JSON.stringify(user), httpOptions);
    }

    buyerSignUp(user) {
      return this.http.post(`${environment.baseUrl}/buyer`, JSON.stringify(user), httpOptions);
    }

    sellerSignUp(user) {
      return this.http.post(`${environment.baseUrl}/seller`, JSON.stringify(user), httpOptions);
    }

    logout() {
      sessionStorage.removeItem('token');
      sessionStorage.removeItem('role');
    }

    getLoginUserType() {
      return sessionStorage.getItem('role');
    }

    isLogged() {
      if(sessionStorage.getItem('token')) {
        return true;
      } else {
        return false;
      }
    }

    isBuyerLogged() {
      if(sessionStorage.getItem('role') == 'buyer') {
        return this.isLogged();
      }
      return false;
    }

    isSellerLogged() {
      if(sessionStorage.getItem('role') == 'seller') {
        return this.isLogged();
      }
      return false;
    }

}
