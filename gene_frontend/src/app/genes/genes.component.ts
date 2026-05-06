import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { Gene, GeneService } from '../services/gene.services';
import { AdminService } from '../admin.services';
import { AuthService } from '../services/auth.service';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-genes',
  standalone: true,
  templateUrl: './genes.component.html',
  imports: [CommonModule, FormsModule, RouterLink]   // για *ngIf και *ngFor
})
export class GenesComponent implements OnInit {
  genes: Gene[] = [];
  loading = true;
  error: string | null = null;

  geneName: string = '';
  description: string = '';
  operator: string = 'AND'; // default

  constructor(public auth: AuthService,
    private geneService: GeneService,
    private router: Router,
    public adminService: AdminService   // inject admin service
  ) {}

  ngOnInit(): void {
    this.loadGenes();
  }

  // === Load all genes ===
  loadGenes(): void {
    this.loading = true;
    this.error = null;

    this.geneService.getAll().subscribe({
      next: (data) => {
        this.genes = data || [];
        this.loading = false;
      },
      error: (err) => {
        console.error("❌ Error loading genes:", err);
        this.error = "Failed to load genes.";
        this.genes = [];
        this.loading = false;
      }
    });
  }

  deleteGene(id: string): void {
    if (confirm("Are you sure you want to delete this gene?")) {
      this.geneService.delete(id).subscribe({
        next: () => {
          alert("✅ Gene deleted successfully");
          this.loadGenes(); // ανανέωση λίστας
        },
        error: (err) => {
          console.error("❌ Delete failed", err);
          alert(`❌ Delete failed: ${err.status} ${err.message}`);
        }
      });
    }
  }


  // === Edit gene (Admin only) ===
  editGene(id: string): void {
    if (!this.adminService.isAdmin) return;
    this.router.navigate(['/genes/edit', id]);
  }

  // === View details (all users) ===
  viewDetails(id: string): void {
    this.router.navigate(['/genes/details', id]);
  }

  // === Create new gene (Admin only) ===
  newGene(): void {
    if (!this.adminService.isAdmin) return;
    this.router.navigate(['/genes/new']);
  }

  // === Search genes ===
  searchGenes(): void {
    this.loading = true;
    this.geneService.searchGenes(this.geneName, this.description, this.operator)
      .subscribe({
        next: (data) => {
          this.genes = data;
          this.loading = false;
        },
        error: (err) => {
          console.error("❌ Error searching genes:", err);
          this.error = "Search failed.";
          this.genes = [];
          this.loading = false;
        }
      });
  }
}
