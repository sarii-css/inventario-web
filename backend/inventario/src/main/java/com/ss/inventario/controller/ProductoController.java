package com.ss.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ss.inventario.model.Producto;
import com.ss.inventario.service.ProductoService;

@RestController
@RequestMapping("/productos")
@CrossOrigin("*")
public class ProductoController {
    
    @Autowired
    private ProductoService service;

    // 🔹 READ (ver todos)
    @GetMapping
    public List<Producto> obtenerTodos() {
        return service.obtenerTodos();
    }

    // 🔹 CREATE y UPDATE
    @PostMapping
    public Producto guardar(@RequestBody Producto producto) {
        return service.guardar(producto);
    }

    // 🔹 DELETE
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }

    // 🔹 READ por ID 
    @GetMapping("/{id}")
    public Producto obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id);
    }
}
