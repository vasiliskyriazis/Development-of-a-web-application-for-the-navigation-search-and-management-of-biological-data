import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { GeneService } from '../services/gene.services';

@Component({
  selector: 'app-gene-details',
  standalone: true,
  templateUrl: './gene-details.component.html',
  imports: [CommonModule]   
})
export class GeneDetailsComponent implements OnInit {
  gene: any;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private geneService: GeneService
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id')!;
    this.geneService.getById(id).subscribe({
      next: (data) => {
        this.gene = data;
      },
      error: (err) => {
        console.error("❌ Error loading gene details:", err);
      }
    });
  }

  backToList() {
    this.router.navigate(['/genes']);
  }
}
