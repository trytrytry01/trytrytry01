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
  sellerName: string;
  manufacturer: string;
}

const PRODUCTS: ProductItem[] = [{
    id: '1',
    itemImage:'./assets/img/sumsung Galaxy S7.jpg',
    itemName: 'Sumsung Galaxy S7',
    price: 1299,
    sellerName:'seller1',
    manufacturer:'SUMSUNG'
}, {
  id: '2',
  itemImage:'./assets/img/huawei P30.jpg',
  itemName: 'HUAWEI P30',
  price: 1599,
  sellerName:'seller2',
  manufacturer:'HUAWEI'
  }, {
    id: '3',
    itemImage:'./assets/img/sumsung Galaxy S7.jpg',
    itemName: 'Sumsung Galaxy S10',
    price: 1599,
    sellerName:'seller1',
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
  searchKey:string = "";
  priceFrom:string="";
  priceTo:string="";
  manufacturer:string="";

  constructor(
    private itemService: ItemService,
    private router: Router) {}

  ngOnInit() {}

  doSearch(searchKey) {
    this.itemService.searchItems(searchKey).subscribe(
      data => {
        debugger
        console.log(JSON.stringify(data));
        const info: any = data;
        if (info.statusCode==200) {
          this.allItems = info.data;
        } else {
          this.alerts.push({type : 'danger', message: 'A server error occured!'});
        }
      },
      error => {
        debugger
        console.error('An error occurred:', error.message);
        this.alerts.push({type : 'danger', message: 'A server error occured!'});
      } // error path
    );

    // this.allItems = PRODUCTS;
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

  close(alert: Alert) {
    this.alerts.splice(this.alerts.indexOf(alert), 1);
  }

}
