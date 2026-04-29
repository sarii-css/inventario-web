import { Producto } from './producto';
import { Usuario } from './usuario';

export interface Movimiento {
  idProducto: Producto;
  idUsuario: Usuario;
  tipo: string;
  cantidad: number;
  fechaventa?: string;
}