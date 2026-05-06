

import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },

  { path: 'login', loadComponent: () => import('./login/login.component').then(m => m.LoginComponent) },

  { path: 'genes', loadComponent: () => import('./genes/genes.component').then(m => m.GenesComponent) },

  { path: 'genes/new', loadComponent: () => import('./genes/gene-create.component').then(m => m.GeneCreateComponent) },

  { path: 'genes/edit/:id', loadComponent: () => import('./genes/gene-edit.component').then(m => m.GeneEditComponent) },

  { path: 'genes/:id', loadComponent: () => import('./genes/gene-details.component').then(m => m.GeneDetailsComponent) },

  { path: '**', redirectTo: 'genes' }
];
