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

    public List<Usuario> obtenerTodos() {
        return repository.findAll();
    }

    public Usuario guardar(Usuario usuario) {
        return repository.save(usuario);
    }

    public void eliminar(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Usuario no existe");
        }
        repository.deleteById(id);
    }

    public Usuario obtenerPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }
}