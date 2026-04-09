package com.ss.inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.inventario.model.Usuario;
import com.ss.inventario.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository repository;

    // 🔹 READ (ver todos)
    public List<Usuario> obtenerTodos() {
        return repository.findAll();
    }

    // 🔹 CREATE y UPDATE
    public Usuario guardar(Usuario usuario) {
        return repository.save(usuario);
    }

    // 🔹 DELETE
    public void eliminar(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Producto no existe");
        }
        repository.deleteById(id);
    }

    // 🔹 READ por ID (extra pro)
    public Usuario obtenerPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }
}