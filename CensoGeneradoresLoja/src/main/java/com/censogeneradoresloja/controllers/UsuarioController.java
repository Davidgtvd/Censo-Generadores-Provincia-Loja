/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja.controllers;

/**
 *
 * @author david
 */
import com.censogeneradoresloja.models.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioController {

    // Lista para almacenar los usuarios (temporal, en lugar de una base de datos)
    private final List<Usuario> usuarios;

    public UsuarioController() {
        this.usuarios = new ArrayList<>();
    }

    // Crear un nuevo usuario
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Obtener un usuario por ID (usando Long en lugar de int)
    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return usuarios.stream()
                       .filter(usuario -> usuario.getId().equals(id)) // Cambiado a .equals para Long
                       .findFirst();
    }

    // Obtener todos los usuarios
    public List<Usuario> obtenerTodosLosUsuarios() {
        return new ArrayList<>(usuarios);
    }

    // Actualizar un usuario existente
    public boolean actualizarUsuario(Long id, Usuario usuarioActualizado) {
        return obtenerUsuarioPorId(id).map(usuario -> {
            int index = usuarios.indexOf(usuario);
            usuarios.set(index, usuarioActualizado);
            return true;
        }).orElse(false);
    }

    // Eliminar un usuario por ID
    public boolean eliminarUsuario(Long id) {
        return usuarios.removeIf(usuario -> usuario.getId().equals(id)); // Cambiado a Long
    }
}