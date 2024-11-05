/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja.views.panels;

/**
 *
 * @author david
 */
import com.censogeneradoresloja.controllers.EstadisticasController;
import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class EstadisticaPanel extends JPanel {
    private final EstadisticasController estadisticasController;
    private final JTextArea estadisticasArea;

    public EstadisticaPanel(EstadisticasController estadisticasController) {
        this.estadisticasController = estadisticasController;
        setLayout(new BorderLayout());

        // Crear componentes
        estadisticasArea = new JTextArea();
        estadisticasArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(estadisticasArea);

        JButton actualizarButton = new JButton("Actualizar Estadísticas");
        actualizarButton.addActionListener(e -> actualizarEstadisticas());

        // Agregar componentes
        add(scrollPane, BorderLayout.CENTER);
        add(actualizarButton, BorderLayout.SOUTH);

        // Cargar estadísticas iniciales
        actualizarEstadisticas();
    }

    private void actualizarEstadisticas() {
        // Asumiendo que los métodos no lanzan IOException
        DecimalFormat df = new DecimalFormat("#,##0.00");
        StringBuilder stats = new StringBuilder();

        // Obtener estadísticas
        var comprasPorFamilia = estadisticasController.obtenerEstadisticasCompra();
        double promedioConsumo = estadisticasController.obtenerPromedioConsumo();
        double costoTotal = estadisticasController.obtenerCostoTotalGeneradores();

        // Construir reporte
        stats.append("=== Estadísticas de Generadores ===\n\n");
        stats.append("Compras por Familia:\n");
        comprasPorFamilia.forEach((familia, cantidad) -> 
            stats.append(String.format("- %s: %d generador(es)\n", familia, cantidad)));

        stats.append("\nPromedio de Consumo: ").append(df.format(promedioConsumo)).append(" L/h\n");
        stats.append("Costo Total en Generadores: $").append(df.format(costoTotal)).append("\n");

        estadisticasArea.setText(stats.toString());
    }
}