import { Component, OnInit } from '@angular/core';
import {ItemService} from '../../services/item.service'
import{Router} from '@angular/router';

interface Alert {
  type: string;
  message: string;
}

interface ProductItem {
  id: string;
  itemImage:string;
  itemName: string;
  price: number;
  seller: string;
  manufacturer: string;
}

const PRODUCTS: ProductItem[] = [{
    id: '1',
    itemImage:'./assets/img/sumsung Galaxy S7.jpg',
    itemName: 'Sumsung Galaxy S7',
    price: 1299,
    seller:'seller1',
    manufacturer:'SUMSUNG'
}, {
  id: '2',
  itemImage:'./assets/img/huawei P30.jpg',
  itemName: 'HUAWEI P30',
  price: 1599,
  seller:'seller2',
  manufacturer:'HUAWEI'
  }, {
    id: '3',
    itemImage:'./assets/img/sumsung Galaxy S7.jpg',
    itemName: 'Sumsung Galaxy S10',
    price: 1599,
    seller:'seller1',
    manufacturer:'SUMSUNG'
    }
];

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {

  alerts: Alert[];
  allItems:ProductItem[];
  searchKey:string;
  priceFrom:string;
  priceTo:string;
  manufacturer:string;

  constructor(private itemService: ItemService,
    private router: Router) {}

  ngOnInit() {}

  doSearch(searchKey) {
    this.itemService.searchItems(searchKey).subscribe(
      data => {
        console.log(JSON.stringify(data));
        const info: any = data;
        if (info.code==200) {
          this.allItems = info.items;
        } else if(info.code==404) {
          this.alerts.push({type : 'info', message: 'username or password error!'});
        } else {
          this.alerts.push({type : 'danger', message: 'A server error occured!'});
        }
      },
      error => {
        console.error('An error occurred:', error.error.message);
        this.alerts.push({type : 'danger', message: 'A server error occured!'});
      } // error path
    );

    this.allItems = PRODUCTS;
  }

  doFilter(priceFrom, priceTo, manufacturer) {
    if(priceFrom == "") {
      priceFrom = 0;
    }
    if(priceTo == "") {
      priceTo = 99999999; //max price is 99999999
    }

    this.allItems.filter(
      element => {
        element.price>=priceFrom, 
        element.price<=priceTo, 
        element.manufacturer=manufacturer
    });

    if(manufacturer != "Any" && manufacturer != "") {
      this.allItems.filter(
        element => {
          element.manufacturer=manufacturer      
      });
    }
   
  }

  viewDetail(itemId:string) {
    this.router.navigate(['/item-detail/'+itemId]);
  }

}
