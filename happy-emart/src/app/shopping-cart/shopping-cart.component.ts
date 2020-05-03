import { Component, OnInit } from '@angular/core';
import {ShoppingCartService} from '../services/shoppingCart.service';
import{Router} from '@angular/router';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {

 
  cartItems: any;
  isEmpty: boolean;
  currentBuyer: any;
  constructor(protected cartService:ShoppingCartService, protected router: Router) { }

  ngOnInit(): void {
    
    this.cartItems = this.cartService.getAllCart();
    
    if(this.cartItems.length==0){
      this.isEmpty=false;
    }
    else{
      this.isEmpty=true;
    }
  }

  deleteCartItem(itemNo: string){
    this.cartItems = this.cartService.deleteCartItem(itemNo);
    if(this.cartItems.length==0){
      this.isEmpty=false;
    }
    else{
      this.isEmpty=true;
    }
  }

  checkOut(Items: any){
    this.cartService.setAllCart(Items);
    this.router.navigate(['bill-view']);
  }

}
