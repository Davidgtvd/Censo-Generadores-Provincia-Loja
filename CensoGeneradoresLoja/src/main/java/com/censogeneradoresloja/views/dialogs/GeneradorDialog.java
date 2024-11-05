/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja.views.dialogs;

/**
 *
 * @author david
 */
import com.censogeneradoresloja.controllers.GeneradorController;
import com.censogeneradoresloja.models.Generador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class GeneradorDialog extends JDialog {
    private final GeneradorController generadorController;
    private final JTextField txtId, txtMarca, txtModelo, txtPotencia, txtConsumoCombustible, txtPrecio, txtUso, txtPropietario;
    private boolean guardadoExitoso;
    private Generador generador;

    public GeneradorDialog(Window parent, GeneradorController generadorController) {
        super(parent, "Nuevo Generador", ModalityType.APPLICATION_MODAL);
        this.generadorController = generadorController;

        txtId = new JTextField(20);
        txtMarca = new JTextField(20);
        txtModelo = new JTextField(20); // Campo para modelo
        txtPotencia = new JTextField(20);
        txtConsumoCombustible = new JTextField(20);
        txtPrecio = new JTextField(20);
        txtUso = new JTextField(20);
        txtPropietario = new JTextField(20); // Campo para propietario

        JPanel panelCampos = new JPanel(new GridLayout(8, 2, 5, 5)); // Ajuste a 8 filas
        panelCampos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        agregarCampo(panelCampos, "ID:", txtId);
        agregarCampo(panelCampos, "Marca:", txtMarca);
        agregarCampo(panelCampos, "Modelo:", txtModelo); // Agregado modelo
        agregarCampo(panelCampos, "Potencia (W):", txtPotencia);
        agregarCampo(panelCampos, "Consumo Combustible (L/h):", txtConsumoCombustible);
        agregarCampo(panelCampos, "Precio ($):", txtPrecio);
        agregarCampo(panelCampos, "Uso:", txtUso);
        agregarCampo(panelCampos, "Propietario:", txtPropietario); // Agregado propietario

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnGuardar = new JButton("Guardar");
        JButton btnCancelar = new JButton("Cancelar");
        btnGuardar.addActionListener(this::guardarGenerador);
        btnCancelar.addActionListener(e -> dispose());
        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);

        add(panelCampos, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(parent);
        guardadoExitoso = false;
    }

    private void agregarCampo(JPanel panel, String label, JTextField field) {
        panel.add(new JLabel(label));
        panel.add(field);
    }

    private void guardarGenerador(ActionEvent e) {
        try {
            long id = Long.parseLong(txtId.getText().trim());
            String marca = txtMarca.getText().trim();
            String modelo = txtModelo.getText().trim(); // Obtener el modelo
            double potencia = Double.parseDouble(txtPotencia.getText().trim());
            double consumo = Double.parseDouble(txtConsumoCombustible.getText().trim());
            double precio = Double.parseDouble(txtPrecio.getText().trim());
            String uso = txtUso.getText().trim();
            String propietario = txtPropietario.getText().trim(); // Obtener el propietario

            generador = new Generador(id, marca, modelo, precio, consumo, potencia, uso, propietario);
            generadorController.registrarGenerador(generador);
            guardadoExitoso = true;
            JOptionPane.showMessageDialog(this, "Generador guardado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores numéricos válidos", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar el generador: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean isGuardadoExitoso() {
        return guardadoExitoso;
    }

    public Generador getGenerador() {
        return generador;
    }
}