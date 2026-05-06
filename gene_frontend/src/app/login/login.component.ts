import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './login.component.html'
})
export class LoginComponent {
  username = '';
  password = '';
  error = '';

  constructor(private router: Router, private auth: AuthService) {}

  login() {
    if (this.username && this.password) {
      this.auth.login(this.username, this.password);

      // μετάβαση στη λίστα
      this.router.navigate(['/genes']);
    } else {
      this.error = 'Please enter username and password';
    }
  }
}
