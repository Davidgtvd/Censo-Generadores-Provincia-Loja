/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja.dao;

/**
 *
 * @author david
 */

import com.censogeneradoresloja.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioDAO {

    private final List<Usuario> usuarios = new ArrayList<>();

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public List<Usuario> obtenerTodosUsuarios() {
        return new ArrayList<>(usuarios);
    }

    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return usuarios.stream()
                       .filter(usuario -> usuario.getId().equals(id))
                       .findFirst();
    }

    public boolean actualizarUsuario(Usuario usuarioActualizado) {
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);
            if (usuario.getId().equals(usuarioActualizado.getId())) {
                usuarios.set(i, usuarioActualizado);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarUsuario(Long id) {
        return usuarios.removeIf(usuario -> usuario.getId().equals(id));
    }
}