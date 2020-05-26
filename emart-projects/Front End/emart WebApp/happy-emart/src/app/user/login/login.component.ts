import { Component, OnInit } from '@angular/core';
import{Router} from '@angular/router';
import {UserService} from '../../services/user.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms'

interface Alert {
  type: string;
  message: string;
}

const ALERTS: Alert[] = [];

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm;
  alerts: Alert[];
  role:string;

  constructor(
    private userService: UserService, 
    private router: Router,
    private formBuilder: FormBuilder,) { 

    this.loginForm = this.formBuilder.group({
        username: '',
        password: '',
        userType: '0'
      })
    }

  ngOnInit() {
    if(sessionStorage.getItem('token')) {
      if(sessionStorage.getItem('role') == 'seller') {
        this.router.navigate(['/viewStock']);
      } else {
        this.router.navigate(['/products']);
      }
    }

    //init the default login as 0:buyer
    // this.userType = '0';
  }

  onSubmit(value: any) {

    if (this.validInput(value)) {
      this.userService.postSignIn(value).subscribe(
        data => {
          debugger
          console.log(JSON.stringify(data));
          const info: any = data;
          if (200 === info.statusCode) {
              sessionStorage.setItem('token', info.data);
              sessionStorage.setItem('role', value.userType); 
              if(value.userType == "0") { //0:buyer login
                //route to the search items page
                this.router.navigate(['/items']);
              } else { //1:seller login
                //route to the add item page
                this.router.navigate(['/add-item']);
              }

          } else {
            if(info.messages.length == 0) {
              this.alerts.push({type : 'danger', message: 'A server error occured!'});
            } else {
              for(var msg of info.messages) {
                this.alerts.push({type : 'danger', message: msg});
              }
            }
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
    debugger
    if (!value.username) {
      this.alerts.push({type : 'danger', message: 'username is required!'});
      result = false;
    }

    if (!value.password) {
      this.alerts.push({type : 'danger', message: 'password is required!'});
      result =  false;
    }

    if (value.password.length < 6) {
      this.alerts.push({type : 'danger', message: 'password length must be greater than 6!'});
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

    buyerSignUp() {
      this.router.navigate(['/buyer/signup']);
    }

    sellerSignUp() {
      this.router.navigate(['/seller/signup']);
    }

}
