/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja.views;

/**
 *
 * @author david
 */

import javax.swing.*;
import java.awt.*; // Asegúrate de importar las librerías necesarias
import com.censogeneradoresloja.controllers.GeneradorController;
import com.censogeneradoresloja.controllers.UsuarioController;
import com.censogeneradoresloja.controllers.TransaccionController;
import com.censogeneradoresloja.controllers.EstadisticasController;

public class MainFrame extends JFrame {

    private GeneradorController generadorController;
    private UsuarioController usuarioController;
    private TransaccionController transaccionController;
    private EstadisticasController estadisticasController;

    // Constructor de la ventana principal
    public MainFrame(GeneradorController generadorController, UsuarioController usuarioController,
                     TransaccionController transaccionController, EstadisticasController estadisticasController) {
        this.generadorController = generadorController;
        this.usuarioController = usuarioController;
        this.transaccionController = transaccionController;
        this.estadisticasController = estadisticasController;

        initUI();
    }

    // Método para inicializar la interfaz de usuario
    private void initUI() {
        setTitle("Censo Generadores Loja");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Ejemplo de configuración de un layout y de un panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        
        // Puedes añadir aquí más elementos a mainPanel, como botones, etiquetas, etc.
        JLabel label = new JLabel("Bienvenido al sistema de Censo Generadores Loja", SwingConstants.CENTER);
        mainPanel.add(label, BorderLayout.CENTER);

        JButton botonEjemplo = new JButton("Ejecutar acción");
        botonEjemplo.addActionListener(e -> ejecutarAccion());
        mainPanel.add(botonEjemplo, BorderLayout.SOUTH);

        // Añade el panel a la ventana
        add(mainPanel);
    }

    // Método de ejemplo para manejar alguna acción
    private void ejecutarAccion() {
        // Aquí puedes interactuar con los controladores
        JOptionPane.showMessageDialog(this, "Acción ejecutada!");
    }

    // Método main opcional para ejecutar la aplicación directamente desde esta clase
    public static void main(String[] args) {
        // Asegurarse de que todos los controladores estén correctamente inicializados
        GeneradorController generadorController = new GeneradorController();
        UsuarioController usuarioController = new UsuarioController();
        TransaccionController transaccionController = new TransaccionController();
        EstadisticasController estadisticasController = new EstadisticasController(generadorController, usuarioController);

        // Crear y mostrar la ventana principal
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame(
                    generadorController,
                    usuarioController,
                    transaccionController,
                    estadisticasController
            );
            mainFrame.setVisible(true);
        });
    }
}
