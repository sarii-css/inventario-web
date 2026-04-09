package com.ss.inventario.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.inventario.model.Movimiento;
import com.ss.inventario.model.Producto;
import com.ss.inventario.repository.MovimientoRepository;
import com.ss.inventario.repository.ProductoRepository;

@Service
public class MovimientoService {

    @Autowired
    private MovimientoRepository repository;

    @Autowired
    private ProductoRepository productoRepository;

    // 🔹 READ
    public List<Movimiento> obtenerTodos() {
        return repository.findAll();
    }

    // 🔥 CREATE (con lógica real)
    public Movimiento guardar(Movimiento movimiento) {

        // 🔹 obtener producto
        Producto producto = productoRepository
                .findById(movimiento.getIdProducto().getIdPK())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // 🔥 lógica de inventario
        if (movimiento.getTipo().equalsIgnoreCase("ENTRADA")) {
            producto.setStock(producto.getStock() + movimiento.getCantidad());
        } 
        else if (movimiento.getTipo().equalsIgnoreCase("SALIDA")) {
            if (producto.getStock() < movimiento.getCantidad()) {
                throw new RuntimeException("Stock insuficiente");
            }
            producto.setStock(producto.getStock() - movimiento.getCantidad());
        } 
        else {
            throw new RuntimeException("Tipo de movimiento inválido");
        }

        // 🔹 guardar producto actualizado
        productoRepository.save(producto);

        // 🔹 fecha automática
        movimiento.setFechaventa(LocalDate.now());

        return repository.save(movimiento);
    }

    // 🔹 DELETE
    public void eliminar(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Movimiento no existe");
        }
        repository.deleteById(id);
    }

    // 🔹 READ por ID
    public Movimiento obtenerPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }
}