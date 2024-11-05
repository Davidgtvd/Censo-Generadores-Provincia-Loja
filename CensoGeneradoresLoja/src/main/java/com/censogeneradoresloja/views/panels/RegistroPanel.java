/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja.views.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import com.censogeneradoresloja.controllers.GeneradorController;
import com.censogeneradoresloja.models.Generador;

public class RegistroPanel extends JPanel {
    private final GeneradorController generadorController;
    private final JTextField txtId, txtMarca, txtModelo, txtPotencia, txtConsumoCombustible, txtPrecio, txtUso, txtPropietario;
    private JButton btnRegistrar;

    public RegistroPanel(GeneradorController generadorController) {
        this.generadorController = generadorController;

        setLayout(new GridLayout(9, 2, 5, 5));
        setBorder(BorderFactory.createTitledBorder("Registro de Generadores"));

        txtId = new JTextField(20);
        txtMarca = new JTextField(20);
        txtModelo = new JTextField(20);
        txtPotencia = new JTextField(20);
        txtConsumoCombustible = new JTextField(20);
        txtPrecio = new JTextField(20);
        txtUso = new JTextField(20);
        txtPropietario = new JTextField(20);

        agregarCampo("ID:", txtId);
        agregarCampo("Marca:", txtMarca);
        agregarCampo("Modelo:", txtModelo);
        agregarCampo("Potencia (W):", txtPotencia);
        agregarCampo("Consumo Combustible (L/h):", txtConsumoCombustible);
        agregarCampo("Precio ($):", txtPrecio);
        agregarCampo("Uso:", txtUso);
        agregarCampo("Propietario:", txtPropietario);

        btnRegistrar = new JButton("Registrar Generador");
        btnRegistrar.addActionListener(this::registrarGenerador);
        add(btnRegistrar);
    }

    private void agregarCampo(String label, JTextField field) {
        add(new JLabel(label));
        add(field);
    }

    private void registrarGenerador(ActionEvent e) {
        try {
            long id = Long.parseLong(txtId.getText().trim());
            String marca = txtMarca.getText().trim();
            String modelo = txtModelo.getText().trim();
            double potencia = Double.parseDouble(txtPotencia.getText().trim());
            double consumo = Double.parseDouble(txtConsumoCombustible.getText().trim());
            double precio = Double.parseDouble(txtPrecio.getText().trim());
            String uso = txtUso.getText().trim();
            String propietario = txtPropietario.getText().trim();

            Generador generador = new Generador(id, marca, modelo, precio, consumo, potencia, uso, propietario);
            generadorController.registrarGenerador(generador);
            JOptionPane.showMessageDialog(this, "Generador registrado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos(); // Limpia los campos después del registro
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores numéricos válidos", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al registrar el generador: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtPotencia.setText("");
        txtConsumoCombustible.setText("");
        txtPrecio.setText("");
        txtUso.setText("");
        txtPropietario.setText("");
    }
}