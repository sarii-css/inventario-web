package com.ss.inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.inventario.model.Producto;
import com.ss.inventario.repository.ProductoRepository;

@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository repository;

    // 🔹 READ (ver todos)
    public List<Producto> obtenerTodos() {
        return repository.findAll();
    }

    // 🔹 CREATE y UPDATE
    public Producto guardar(Producto producto) {
        return repository.save(producto);
    }

    // 🔹 DELETE
    public void eliminar(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Producto no existe");
        }
        repository.deleteById(id);
    }

    // 🔹 READ por ID (extra pro)
    public Producto obtenerPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
