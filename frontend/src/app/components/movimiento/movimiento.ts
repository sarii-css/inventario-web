import { Component } from '@angular/core';
import { MovimientoService } from '../../services/movimiento';

@Component({
  selector: 'app-movimiento',
  templateUrl: './movimiento.html'
})
export class MovimientoComponent {

  movimiento = {
    idProducto: { id: 3 },
    idUsuario: { id: 1 },
    tipo: 'SALIDA',
    cantidad: 1
  };

  constructor(private movimientoService: MovimientoService) {}

  guardar() {
    this.movimientoService.guardar(this.movimiento).subscribe({
      next: res => {
        console.log('Guardado', res);
      },
      error: err => {
        console.error('Error', err);
      }
    });
  }
}