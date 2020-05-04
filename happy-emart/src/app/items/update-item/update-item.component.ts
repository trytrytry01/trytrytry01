import { Component, OnInit } from '@angular/core';
import{Router} from '@angular/router';
import {ItemService} from '../../services/item.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms'

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

interface Alert {
  type: string;
  message: string;
}

const ALERTS: Alert[] = [];

@Component({
  selector: 'app-update-item',
  templateUrl: './update-item.component.html',
  styleUrls: ['./update-item.component.css']
})
export class UpdateItemComponent implements OnInit {


  stockForm;
  alerts: Alert[];
  allItems:ProductItem[];

  constructor(
    private itemService: ItemService, 
    private router: Router,
    private formBuilder: FormBuilder,) { 
      this.allItems = ITEMS;
      this.stockForm = this.formBuilder.group({
        price: '',
        stock:''
        })
    }

  ngOnInit() {
    this.allItems = ITEMS;
   }

  onSubmit(value: any) {
    if (this.validInput(value)) {
      this.itemService.updateItems(value).subscribe(
        data => {
          console.log(JSON.stringify(data));
          const info: any = data;
          if (200 === info.code) {
              alert('Update Item Compelted!');
          } else {
            console.error('An error occurred:status code=', info.code);
            this.alerts.push({type : 'danger', message: 'A server error occured!'});
          }
        },
        error => {
          console.error('An error occurred:', error.error.message);
          this.alerts.push({type : 'danger', message: 'A server error occured!'});
        } // error path
      );
    }
  }

  validInput(value: any): boolean {
    this.reset();
    let result = true

    // if (!value.itemName) {
    //   this.alerts.push({type : 'danger', message: 'Item Name is required!'});
    //   result = false;
    // }

    // if (!value.price) {
    //   this.alerts.push({type : 'danger', message: 'Price is required!'});
    //   result =  false;
    // }


    return result;
  }

  close(alert: Alert) {
    this.alerts.splice(this.alerts.indexOf(alert), 1);
  }
  
  reset() {
      this.alerts = Array.from(ALERTS);
  }

}
