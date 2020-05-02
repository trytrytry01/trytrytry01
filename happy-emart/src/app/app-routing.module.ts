import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginGuard} from './guard/login.guard'
import {LoginComponent} from './user/login/login.component';
import {BuyerSignupComponent} from './user/buyer-signup/buyer-signup.component';
import {SellerSignupComponent} from './user/seller-signup/seller-signup.component';
import {ItemListComponent} from './items/item-list/item-list.component';
import {ItemDetailComponent} from './items/item-detail/item-detail.component';
import {ShoppingCartComponent} from './shopping-cart/shopping-cart.component';
import {PurchaseHistoryComponent} from './purchase-history/purchase-history.component';
import {AddItemComponent} from './items/add-item/add-item.component';
import {UpdateItemComponent} from './items/update-item/update-item.component';

// import {ProductComponent} from './pages/product/product.component';'

const routes: Routes = [
  { path: 'login', component: LoginComponent},
  { path: 'buyer/signup', component: BuyerSignupComponent},
  { path: 'seller/signup', component: SellerSignupComponent},
  { path: 'items', component: ItemListComponent},
  { path: 'item-detail/:id', component: ItemDetailComponent},
  { path: 'add-item', component: AddItemComponent},
  { path: 'update-item', component: UpdateItemComponent},
  { path: 'shopping-cart', component: ShoppingCartComponent},
  { path: 'purchase-history', component: PurchaseHistoryComponent},
  
  // { path: 'products', component: ProductComponent, canActivate: [LoginGuard]},
  // { path: 'product/:id', component: ProductDetailComponent, canActivate: [LoginGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
