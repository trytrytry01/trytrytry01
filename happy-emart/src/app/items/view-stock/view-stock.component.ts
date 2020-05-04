import { Component, OnInit } from '@angular/core';

interface ProductItem {
  id: string;
  itemName:string;
  category: string;
  subCategory: string,
  price: number;
  stock: number;
}

const ITEMS: ProductItem[] = [{
    id: '1',
    itemName: 'Sumsung Galaxy S7',
    category:'Electronic',
    subCategory:'Mobile',
    price: 1299,
    stock:500,
}, {
  id: '2',
  itemName: 'HUAWEI P30',
  category:'Electronic',
  subCategory:'Mobile',
  price: 1599,
  stock:500,
  }, {
    id: '3',
    itemName: 'Sumsung Galaxy S10',
    category:'Electronic',
    subCategory:'Mobile',
    price: 1599,
    stock:500,
    }
];

@Component({
  selector: 'app-view-stock',
  templateUrl: './view-stock.component.html',
  styleUrls: ['./view-stock.component.css']
})
export class ViewStockComponent implements OnInit {

  allItems:ProductItem[];

  constructor() { }

  ngOnInit() {
    debugger;
    this.allItems = ITEMS;
  }

}
