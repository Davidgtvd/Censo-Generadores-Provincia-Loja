/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja.controllers;

/**
 *
 * @author david
 */
import com.censogeneradoresloja.dao.UsuarioDAO;
import com.censogeneradoresloja.models.Usuario;

import java.util.List;
import java.util.Optional;

public class UsuarioController {

    private final UsuarioDAO usuarioDAO;

    public UsuarioController(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public void agregarUsuario(Usuario usuario) {
        usuarioDAO.agregarUsuario(usuario);
    }

    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioDAO.obtenerTodosUsuarios();
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        Optional<Usuario> usuario = usuarioDAO.obtenerUsuarioPorId(id);
        return usuario.orElse(null);
    }

    public boolean actualizarUsuario(Usuario usuarioActualizado) {
        return usuarioDAO.actualizarUsuario(usuarioActualizado);
    }

    public boolean eliminarUsuario(Long id) {
        return usuarioDAO.eliminarUsuario(id);
    }
}