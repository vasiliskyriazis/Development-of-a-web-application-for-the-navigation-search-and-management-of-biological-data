import { Injectable, inject, PLATFORM_ID } from '@angular/core';
import { HttpHeaders } from '@angular/common/http';
import { isPlatformBrowser } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private storageKey = 'basicAuth';   // unified key
  private roleKey = 'role';
  private platformId = inject(PLATFORM_ID);

  login(username: string, password: string): void {
    if (isPlatformBrowser(this.platformId)) {
      const token = btoa(`${username}:${password}`);
      localStorage.setItem(this.storageKey, token);

      // απλό demo: όποιος κάνει login με username=admin είναι Admin
      localStorage.setItem(this.roleKey, username === 'admin' ? 'admin' : 'user');
    }
  }

  logout(): void {
    if (isPlatformBrowser(this.platformId)) {
      localStorage.removeItem(this.storageKey);
      localStorage.removeItem(this.roleKey);
    }
  }

  getAuthHeaders(): HttpHeaders {
    const token = localStorage.getItem('basicAuth');
    console.log('🔑 Using token:', token);
    return new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': token ? `Basic ${token}` : ''
    });
  }

  isLoggedIn(): boolean {
    if (isPlatformBrowser(this.platformId)) {
      return !!localStorage.getItem(this.storageKey);
    }
    return false;
  }

  isAdmin(): boolean {
    if (isPlatformBrowser(this.platformId)) {
      return localStorage.getItem(this.roleKey) === 'admin';
    }
    return false;
  }
}
