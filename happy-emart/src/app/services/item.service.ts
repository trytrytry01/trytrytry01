import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../environments/environment';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  
  @Injectable({
    providedIn: 'root'
  })
export class ItemService {

    constructor(private http: HttpClient) { }

    //buyer to search items
    searchItems(searchKey) {
        return this.http.get('${environment.baseUrl}/items/' + searchKey, httpOptions);
    }
   //buyer to view item Detail
    getItem(itemId: string):any{
        return this.http.get('${environment.baseUrl}/item/'+itemId);
      }

    //seller to add item
    addItem(item) {
      return this.http.post(`${environment.baseUrl}/items`, JSON.stringify(item), httpOptions);
    }

    //seller to update items
    updateItems(items) {
        return this.http.put(`${environment.baseUrl}/items`, JSON.stringify(items), httpOptions);
     }

    //seller to view all items
    viewItems() {
        return this.http.get(`${environment.baseUrl}/items`, httpOptions);
    }


}
