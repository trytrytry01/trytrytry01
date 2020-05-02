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
        name: '',
        password: '',
        role: ''
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

    //init the default login as buyer
    this.role = 'buyer';
  }

  onSubmit(value: any) {
    if (this.validInput(value)) {
      this.userService.postSignIn(value).subscribe(
        data => {
          console.log(JSON.stringify(data));
          const info: any = data;
          if (200 === info.code) {
              sessionStorage.setItem('token', info.result.token);
              sessionStorage.setItem('role', value.role); 
              this.router.navigate(['/products']);
          } else {
            this.alerts.push({type : 'danger', message: 'username or password error!'});

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
    if (!value.name) {
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
