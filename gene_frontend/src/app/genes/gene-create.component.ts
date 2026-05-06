import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { GeneService } from '../services/gene.services';

@Component({
  selector: 'app-gene-create',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './gene-create.component.html'
})
export class GeneCreateComponent implements OnInit {
  form!: FormGroup;
  saving = false;

  constructor(
    private fb: FormBuilder,
    private geneService: GeneService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.form = this.fb.group({
      geneId: ['', Validators.required],
      geneName: ['', Validators.required],
      description: [''],
      geneType: [''],
      gcContent: [null],
      chrom: [''],
      geneStart: [null],
      geneEnd: [null],
      transcriptCount: [null],
      geneSynonym: ['']
    });
  }

  submit(): void {
    if (this.form.valid) {
      this.saving = true;
      this.geneService.create(this.form.value).subscribe({
        next: () => this.router.navigate(['/genes']),
        complete: () => (this.saving = false)
      });
    }
  }
  onCancel() {
    this.router.navigate(['/genes']);
  }
}
