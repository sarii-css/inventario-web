import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Movimiento } from '../models/movimiento';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MovimientoService {

  private apiUrl = 'http://localhost:8080/movimientos';

  constructor(private http: HttpClient) {}

  guardar(mov: Movimiento): Observable<any> {
    return this.http.post(this.apiUrl, mov);
  }
}