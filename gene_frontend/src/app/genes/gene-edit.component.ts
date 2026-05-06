
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { Gene, GeneService } from '../services/gene.services';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-gene-edit',
  standalone: true,
  templateUrl: './gene-edit.component.html',
  imports: [CommonModule, FormsModule]
})
export class GeneEditComponent implements OnInit {
  gene: Gene | null = null;
  error: string | null = null;
  loading = true;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private geneService: GeneService,
    public auth: AuthService
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (!id) {
      this.error = 'No gene id provided';
      this.loading = false;
      return;
    }

    this.geneService.getById(id).subscribe({
      next: (data) => {
        this.gene = data;
        this.loading = false;
      },
      error: (err) => {
        console.error('❌ Failed to load gene', err);
        this.error = 'Could not load gene';
        this.loading = false;
      }
    });
  }

  save(): void {
    if (!this.gene) return;

    console.log('🛰 Sending update for gene:', this.gene);

    this.geneService.update(this.gene.geneId, this.gene).subscribe({
      next: () => {
        alert('✅ Gene updated successfully');
        this.router.navigate(['/genes']);
      },
      error: (err) => {
        console.error('❌ Update failed', err);
        alert(
          `❌ Update failed:\nstatus=${err.status}\nmessage=${err.message}\nerror=${JSON.stringify(err.error)}`
        );
      }
    });
  }



  cancel(): void {
    this.router.navigate(['/genes']);
  }
}
