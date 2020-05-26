import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../environments/environment';
  
  @Injectable({
    providedIn: 'root'
  })
export class ItemService {

    constructor(private http: HttpClient) { }

    //buyer to search items
    searchItems(searchKey) {
      var httpOptions = {
        headers: new HttpHeaders({
           'Content-Type': 'application/json',
           'Authorization': sessionStorage.getItem('token')                    
           })
        };
        return this.http.get(`${environment.baseUrl}/api-buyer/items?keywords=` + searchKey, httpOptions);
    }
   //buyer to view item Detail
    getItem(itemId: string):any{
      var httpOptions = {
        headers: new HttpHeaders({
           'Content-Type': 'application/json',
           'Authorization': sessionStorage.getItem('token')                    
           })
        };
        return this.http.get(`${environment.baseUrl}/api-buyer/item/`+itemId, httpOptions);
    }

    //seller to add item
    addItem(item) {
      var httpOptions = {
        headers: new HttpHeaders({
           'Content-Type': 'application/json',
           'Authorization': sessionStorage.getItem('token')                    
           })
        };
      return this.http.post(`${environment.baseUrl}/api-seller/items`, JSON.stringify(item), httpOptions);
    }

    //seller to update items
    updateItems(items) {
      var httpOptions = {
        headers: new HttpHeaders({
           'Content-Type': 'application/json',
           'Authorization': sessionStorage.getItem('token')                    
           })
        };
        return this.http.put(`${environment.baseUrl}/api-seller/items`, JSON.stringify(items), httpOptions);
     }

    //seller to view all items
    viewItems() {
      var httpOptions = {
        headers: new HttpHeaders({
           'Content-Type': 'application/json',
           'Authorization': sessionStorage.getItem('token')                    
           })
        };
        return this.http.get(`${environment.baseUrl}/api-seller/items`, httpOptions);
    }


}
