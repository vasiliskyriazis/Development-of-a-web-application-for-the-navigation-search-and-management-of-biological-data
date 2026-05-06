import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { AuthService } from './auth.service';

// === Interfaces ===
export interface Gene {
  geneId: string;
  geneName: string;
  description: string;
  geneType: string;
  gcContent: number;
  chrom: string;
  geneStart: number;
  geneEnd: number;
  transcriptCount: number;
  geneSynonym: string;
  transcripts: Transcript[];
  variants: Variant[];
}

export interface Transcript {
  transcriptId: string;
  transcriptName: string;
  transcriptStart: number;
  transcriptEnd: number;
  transcriptType: string;
  refseq: string;
}

export interface Variant {
  clinvarId: string;
  chrom: string;
  position: number;
  variantType: string | null;
  clinicalSignificance: string | null;
  rsId: string | null;
  ncbiAccession: string | null;
  ncbiID: string | null;
}

@Injectable({
  providedIn: 'root'
})
export class GeneService {
  private apiUrl = 'http://localhost:8080/api/genes'; //  backend URL

  constructor(private http: HttpClient, private auth: AuthService) {}

  // === GET all genes (για όλους) ===
  getAll(): Observable<Gene[]> {
    return this.http.get<Gene[]>(this.apiUrl);
  }

  // === GET gene by ID (για όλους) ===
  getById(id: string): Observable<Gene> {
    return this.http.get<Gene>(`${this.apiUrl}/${id}`);
  }

  // === CREATE gene (Admin only) ===
  create(gene: Gene): Observable<Gene> {
    return this.http.post<Gene>(this.apiUrl, gene, {
      headers: this.auth.getAuthHeaders()
    });
  }

  update(id: string, gene: Gene): Observable<Gene> {
    const headers = this.auth.getAuthHeaders();
    console.log('🔑 Update request headers:', headers.keys().map(k => `${k}: ${headers.get(k)}`));
    console.log('🌐 Update URL:', `${this.apiUrl}/${id}`);

    return this.http.put<Gene>(`${this.apiUrl}/${id}`, gene, { headers });
  }


  // === DELETE gene (Admin only) ===
  delete(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`, {
      headers: this.auth.getAuthHeaders()
    });
  }

  // === SEARCH genes (για όλους) ===
  searchGenes(geneName: string, description: string, operator: string): Observable<Gene[]> {
    let params = new HttpParams();
    if (geneName) params = params.set('geneName', geneName);
    if (description) params = params.set('description', description);
    if (operator) params = params.set('operator', operator);

    return this.http.get<Gene[]>(`${this.apiUrl}/search`, { params });
  }
}
