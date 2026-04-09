package com.ss.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ss.inventario.model.Movimiento;
import com.ss.inventario.service.MovimientoService;

@RestController
@RequestMapping("/movimientos")
@CrossOrigin("*")
public class MovimientoController {
    
    @Autowired
    private MovimientoService service;

    // 🔹 READ (ver todos)
    @GetMapping
    public List<Movimiento> obtenerTodos() {
        return service.obtenerTodos();
    }

    // 🔹 CREATE y UPDATE
    @PostMapping
    public Movimiento guardar(@RequestBody Movimiento movimiento) {
        return service.guardar(movimiento);
    }

    // 🔹 DELETE
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }

    // 🔹 READ por ID 
    @GetMapping("/{id}")
    public Movimiento obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id);
    }
}   
