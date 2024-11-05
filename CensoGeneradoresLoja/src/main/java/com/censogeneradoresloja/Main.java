/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja;

/**
 *
 * @author david
 */

import com.censogeneradoresloja.controllers.*;
import com.censogeneradoresloja.models.*;
import com.censogeneradoresloja.views.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Establecer look and feel del sistema
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
            // Inicializar controladores
            GeneradorController generadorController = new GeneradorController();
            UsuarioController usuarioController = new UsuarioController();
            TransaccionController transaccionController = new TransaccionController();
            EstadisticasController estadisticasController = new EstadisticasController(
                generadorController, usuarioController);
            
            // Inicializar y mostrar la ventana principal
            SwingUtilities.invokeLater(() -> {
                MainFrame mainFrame = new MainFrame(
                    generadorController,
                    usuarioController,
                    transaccionController,
                    estadisticasController
                );
                mainFrame.setVisible(true);
            });
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Error al iniciar la aplicación: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
}