import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { Movimiento } from './models/movimiento';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    HttpClientModule,
    FormsModule
  ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {

  protected readonly title = signal('frontend');

  constructor(private http: HttpClient) {}

  movimiento: Movimiento = {
  idProducto: { id: 0 },
  idUsuario: { id: 0 },
  tipo: 'ENTRADA',
  cantidad: 0,
  fechaventa: ''
};

  guardar() {
    console.log(this.movimiento);

    this.http.post('http://localhost:8080/movimientos', this.movimiento)
      .subscribe({
        next: (res) => {
          console.log('Guardado:', res);
          alert('Movimiento guardado 😎');

          // reset
          this.movimiento = {
            idProducto: { id: 0 },
            idUsuario: { id: 0 },
            tipo: 'ENTRADA',
            cantidad: 0
          };
        },
        error: (err) => {
          console.error('Error:', err);
          alert('Error al guardar 💀');
        }
      });
  }
}