import { Component, OnInit } from '@angular/core';
import{Router} from '@angular/router';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms'
import {ItemService} from '../../services/item.service';

interface Alert {
  type: string;
  message: string;
}

const ALERTS: Alert[] = [];
@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css']
})
export class AddItemComponent implements OnInit {

  addItemForm;
  alerts: Alert[];

  constructor(
    private itemService: ItemService, 
    private router: Router,
    private formBuilder: FormBuilder,) { 
      this.addItemForm = this.formBuilder.group({
        categoryId: '1',
        subcategoryId: '1',
        itemName: '',
        price:'',
        stockNumber:''
        })
    }

  ngOnInit() {}

  onSubmit(value: any) {
    if (this.validInput(value)) {
      debugger
      this.itemService.addItem(value).subscribe(
        data => {
          console.log(JSON.stringify(data));
          const info: any = data;
          if (200 === info.statusCode) {
              alert('Add Item Compelted!');
          } else {
            console.error('An error occurred:status code=', info.statusCode);
            this.alerts.push({type : 'danger', message: 'A server error occured!'});
          }
        },
        error => {
          debugger
          console.error('An error occurred:', error.message);
          this.alerts.push({type : 'danger', message: 'A server error occured!'});
        } // error path
      );
    }
  }

  validInput(value: any): boolean {
    this.reset();
    let result = true

    if (!value.itemName) {
      this.alerts.push({type : 'danger', message: 'Item Name is required!'});
      result = false;
    }

    if (!value.price) {
      this.alerts.push({type : 'danger', message: 'Price is required!'});
      result =  false;
    }
    if (!value.stockNumber) {
      this.alerts.push({type : 'danger', message: 'No. of Stock Items is required!'});
      result =  false;
    }

    return result;
  }

  close(alert: Alert) {
    this.alerts.splice(this.alerts.indexOf(alert), 1);
  }
  
  reset() {
      this.alerts = Array.from(ALERTS);
  }
}
