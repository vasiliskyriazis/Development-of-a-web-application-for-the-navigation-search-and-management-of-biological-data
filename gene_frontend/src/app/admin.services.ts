import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  private _isAdmin = false;

  get isAdmin(): boolean {
    return this._isAdmin;
  }

  toggleAdmin() {
    this._isAdmin = !this._isAdmin;
  }
}
