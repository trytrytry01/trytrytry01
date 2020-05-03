import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ShoppingCartService {

  cartItems: any;
  currentBuyer : any = null;
  
  constructor(protected http: HttpClient) { 
    this.cartItems = [];
  }

addToCart(itemObj: any){
  this.cartItems.push(itemObj);
 }

 getAllCart(){
   return [].concat(this.cartItems);
 }

 setAllCart(cartItems: any){
   this.cartItems = cartItems;
 }

 deleteCartItem(itemNo: number){
   let size = this.cartItems.length;
   for(let i=0;i<size;i++){
     if(this.cartItems[i].itemId==itemNo){
       this.cartItems.splice(i,1);
       break;
     }
   }
   return [].concat(this.cartItems);
 }

}
