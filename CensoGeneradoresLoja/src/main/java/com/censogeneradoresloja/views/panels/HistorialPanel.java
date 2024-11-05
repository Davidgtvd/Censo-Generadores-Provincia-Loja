/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja.views.panels;

/**
 *
 * @author david
 */
import com.censogeneradoresloja.controllers.TransaccionController;
import com.censogeneradoresloja.models.Transaccion;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class HistorialPanel extends JPanel {
    private final TransaccionController transaccionController;
    private final JTable historialTable;
    private final DateTimeFormatter dateFormatter;

    public HistorialPanel(TransaccionController transaccionController) {
        this.transaccionController = transaccionController;
        this.dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        setLayout(new BorderLayout());

        // Crear tabla
        String[] columnas = {"ID", "Fecha", "Usuario", "Generador", "Operación", "Monto"};
        historialTable = new JTable(new Object[0][6], columnas);
        JScrollPane scrollPane = new JScrollPane(historialTable);

        // Botón de actualizar
        JButton actualizarButton = new JButton("Actualizar Historial");
        actualizarButton.addActionListener(e -> cargarHistorial());

        // Agregar componentes
        add(scrollPane, BorderLayout.CENTER);
        add(actualizarButton, BorderLayout.SOUTH);

        // Cargar datos iniciales
        cargarHistorial();
    }

  private void cargarHistorial() {
    try {
        // Asegúrate de que transaccionController.obtenerHistorial() lanza IOException
        var transacciones = transaccionController.obtenerHistorial();
        actualizarTablaHistorial(transacciones);
    } catch (Exception e) { // Cambiar IOException a Exception si deseas capturar todo tipo de errores.
        JOptionPane.showMessageDialog(this,
            "Error al cargar historial: " + e.getMessage(),
            "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    private void actualizarTablaHistorial(java.util.List<Transaccion> transacciones) {
        // Actualizar modelo de tabla
        // Implementar lógica
    }
}