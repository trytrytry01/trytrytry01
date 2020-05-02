import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './user/login/login.component';
import { BuyerSignupComponent } from './user/buyer-signup/buyer-signup.component';
import { SellerSignupComponent } from './user/seller-signup/seller-signup.component';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';
import { PurchaseHistoryComponent } from './purchase-history/purchase-history.component';
import { AddItemComponent } from './items/add-item/add-item.component';
import { UpdateItemComponent } from './items/update-item/update-item.component';
import {ItemListComponent} from './items/item-list/item-list.component';
import {ItemDetailComponent} from './items/item-detail/item-detail.component';
import { MoneyPipe } from './pipe/money.pipe'

@NgModule({
   declarations: [
      AppComponent,
      HeaderComponent,
      LoginComponent,
      BuyerSignupComponent,
      SellerSignupComponent,
      ShoppingCartComponent,
      PurchaseHistoryComponent,
      AddItemComponent,
      UpdateItemComponent,
      ItemListComponent,
      ItemDetailComponent,
      MoneyPipe
   ],
   imports: [
      BrowserModule,
      AppRoutingModule,
      NgbModule,
      HttpClientModule,
      FormsModule,
      ReactiveFormsModule
   ],
   providers: [],
   bootstrap: [
      AppComponent
   ]
})
export class AppModule { }
