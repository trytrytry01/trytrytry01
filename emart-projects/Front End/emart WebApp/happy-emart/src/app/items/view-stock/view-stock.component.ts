import { Component, OnInit } from '@angular/core';
import {ItemService} from '../../services/item.service';

interface ProductItem {
  id: string;
  itemName:string;
  category: string;
  subCategory: string,
  price: number;
  stockNumber: number;
}

const ITEMS: ProductItem[] = [{
    id: '1',
    itemName: 'Sumsung Galaxy S7',
    category:'Electronic',
    subCategory:'Mobile',
    price: 1299,
    stockNumber:500,
}, {
  id: '2',
  itemName: 'HUAWEI P30',
  category:'Electronic',
  subCategory:'Mobile',
  price: 1599,
  stockNumber:500,
  }, {
    id: '3',
    itemName: 'Sumsung Galaxy S10',
    category:'Electronic',
    subCategory:'Mobile',
    price: 1599,
    stockNumber:500,
    }
];

@Component({
  selector: 'app-view-stock',
  templateUrl: './view-stock.component.html',
  styleUrls: ['./view-stock.component.css']
})
export class ViewStockComponent implements OnInit {

  allItems:ProductItem[];

  constructor(
    private itemService: ItemService
  ) { }

  ngOnInit() {
    debugger;
    this.allItems = ITEMS;

    this.itemService.viewItems().subscribe(
      data => {
        debugger
        console.log(JSON.stringify(data));
        const info: any = data;
        if (200 === info.statusCode) {
          this.allItems = info.data;
        } else {
          console.error('An error occurred:status code=', info.statusCode);
        }
      }
    );


  }

}
