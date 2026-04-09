package com.ss.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ss.inventario.model.Rol;
import com.ss.inventario.service.RolService;

@RestController
@RequestMapping("/roles")
@CrossOrigin("*")
public class RolSontroller {
    
    @Autowired
    private RolService service;

    // 🔹 READ (ver todos)
    @GetMapping
    public List<Rol> obtenerTodos() {
        return service.obtenerTodos();
    }

    // 🔹 CREATE y UPDATE
    @PostMapping
    public Rol guardar(@RequestBody Rol rol) {
        return service.guardar(rol);
    }

    // 🔹 DELETE
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }

    // 🔹 READ por ID 
    @GetMapping("/{id}")
    public Rol obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id);
    }
}