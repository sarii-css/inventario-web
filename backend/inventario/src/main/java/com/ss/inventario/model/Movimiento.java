package com.ss.inventario.model;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "movimientos")
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //permite id = null y evita problemas con la generación automática de IDs en la base de datos
    
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto idProducto;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario idUsuario;
    private String tipo;
    private Integer cantidad;
    private LocalDate fechaventa;
    
    // Getters y setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Producto getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFechaventa() {
        return fechaventa;
    }
    public void setFechaventa(LocalDate fechaventa) {
        this.fechaventa = fechaventa;
    }

}
