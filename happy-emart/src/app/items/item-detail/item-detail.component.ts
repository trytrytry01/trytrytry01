import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ShoppingCartService} from '../../services/shoppingCart.service';
import {ItemService} from '../../services/item.service'

export interface Item{
  id: string,
  name: string,
  seller: string,
  categoryName: string,
  subCategoryName: string,
  price: number,
  image1: string,
  image2: string,
  image3: string,
  image4: string,
  description: string,
  stock: number,
  remarks: string,

}

const ITEM_DETAIL_dummy: Item = {
  id: '1',
  name: 'huawei P30',
  seller: 'seller1',
  categoryName: 'Electronic',
  subCategoryName: 'Mobile',
  price: 3299,
  description: 'huawei P30 packs A13 Bionic, Portrait mode, 4K video, Touch ID, a Retina HD display, and great battery life into a 4.7” design',
  image1:'./assets/img/huawei P30.jpg',
  image2:'./assets/img/huawei P30 2.jpg',
  image3:'./assets/img/huawei P30 3.jpg',
  image4:'./assets/img/huawei P30 4.jpg',
  stock: 1000,
  remarks:''

}

@Component({
  selector: 'app-item-detail',
  templateUrl: './item-detail.component.html',
  styleUrls: ['./item-detail.component.css']
})
export class ItemDetailComponent implements OnInit {

  itemImage:string;
  item:any;

  constructor(private router: Router,
    protected activatedRoute: ActivatedRoute,
    private itemService: ItemService,
    private cartService: ShoppingCartService) { }

  ngOnInit() {
    // this.activatedRoute.paramMap.subscribe(
    //   (param)=>{
    //               let id = param.get('iId');  
    //               this.itemService.getItem(id).subscribe((response)=> {
    //                 this.item =  response;
    //               }
    //               );                                   
    //             }
    // );
    this.item = ITEM_DETAIL_dummy;
    this.toggleImg(1);
  }

  toggleImg(index:number) {
    if(index==2) {
      this.itemImage = this.item.image2;
    } else if(index==3) {
      this.itemImage = this.item.image3;
    } else if(index==4) {
      this.itemImage = this.item.image4;
    } else {
      this.itemImage = this.item.image1;
    }
  }
  backToSearch() {
    this.router.navigate(['/items']);
  }

  addToCart(item:any) {
    this.cartService.addToCart(item);
    this.router.navigate(['items']);
  }

  checkOut(item:any) {
    // this.router.navigate(['bill-view']);
  }

}
