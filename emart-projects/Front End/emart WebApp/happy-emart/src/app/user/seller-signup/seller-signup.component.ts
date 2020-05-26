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
  selector: 'app-seller-signup',
  templateUrl: './seller-signup.component.html',
  styleUrls: ['./seller-signup.component.css']
})
export class SellerSignupComponent implements OnInit {

  sellerForm;
  alerts: Alert[];

  constructor(
    private userService: UserService, 
    private router: Router,
    private formBuilder: FormBuilder,) { 

    this.sellerForm = this.formBuilder.group({
        username: '',
        password: '',
        confirmPassword: '',
        email: '',
        contactNo:'',
        companyName:'',
        gstin: '',
        address: '',
        website:'',
        brief:''
      })
    }

  ngOnInit() { }

  onSubmit(value: any) {
    if (this.validInput(value)) {
      this.userService.sellerSignUp(value).subscribe(
        data => {
          console.log(JSON.stringify(data));
          const info: any = data;
          if (200 === info.statusCode) {
              this.router.navigate(['/login']);
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
          console.error('An error occurred:', error.error.message);
          this.alerts.push({type : 'danger', message: 'A server error occured!'});
        } // error path
      );
    }
  }

  validInput(value: any): boolean {
    this.reset();
    let result = true
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

    if (!value.confirmPassword) {
      this.alerts.push({type : 'danger', message: 'confirm password is required!'});
      result =  false;
    }

    if (value.password != value.confirmPassword) {
      this.alerts.push({type : 'danger', message: 'the confirm password is different with the password!'});
      result =  false;
    }

    if (!value.email) {
      this.alerts.push({type : 'danger', message: 'mail is required!'});
      result =  false;
    }

    if (value.email.indexOf('@') == -1) {
      this.alerts.push({type : 'danger', message: 'mail is required!'});
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

    backToLogin() {
      this.router.navigate(['/login']);
    }

}
