package com.ss.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ss.inventario.model.Usuario;
import com.ss.inventario.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {
    
    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> obtenerTodos() {
        return service.obtenerTodos();
    }

    @PostMapping
    public Usuario guardar(@RequestBody Usuario usuario) {
        return service.guardar(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }

    @GetMapping("/{id}")
    public Usuario obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id);
    }
}
