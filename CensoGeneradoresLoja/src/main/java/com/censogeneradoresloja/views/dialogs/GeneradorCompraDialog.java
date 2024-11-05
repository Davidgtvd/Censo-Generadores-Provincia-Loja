/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja.views.dialogs;

/**
 *
 * @author david
 */
import com.censogeneradoresloja.models.Generador;
import com.censogeneradoresloja.models.Usuario;
import javax.swing.*;
import java.awt.*;

public class GeneradorCompraDialog extends JDialog {
    private final JTextField nombreField, apellidoField, direccionField, telefonoField, emailField;
    private boolean aceptado;
    private final Generador generador;
    private Usuario usuario;

    public GeneradorCompraDialog(Window owner, Generador generador) {
        super(owner, "Registrar Compra", ModalityType.APPLICATION_MODAL);
        this.generador = generador;

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Crear campos de texto
        nombreField = new JTextField(20);
        apellidoField = new JTextField(20);
        direccionField = new JTextField(20);
        telefonoField = new JTextField(20);
        emailField = new JTextField(20);

        // Configuración de campos
        addCampo("Nombre:", nombreField, gbc, 0);
        addCampo("Apellido:", apellidoField, gbc, 1);
        addCampo("Dirección:", direccionField, gbc, 2);
        addCampo("Teléfono:", telefonoField, gbc, 3);
        addCampo("Email:", emailField, gbc, 4);

        // Información del generador
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        add(new JLabel("Generador: " + generador.getMarca() + " " + generador.getModelo()), gbc);
        gbc.gridy = 6;
        add(new JLabel("Precio: $" + generador.getPrecio()), gbc);

        // Botones de acción
        JPanel buttonPanel = new JPanel();
        JButton aceptarButton = new JButton("Registrar Compra");
        JButton cancelarButton = new JButton("Cancelar");
        aceptarButton.addActionListener(e -> aceptar());
        cancelarButton.addActionListener(e -> cancelar());
        buttonPanel.add(aceptarButton);
        buttonPanel.add(cancelarButton);
        gbc.gridy = 7;
        add(buttonPanel, gbc);

        pack();
        setLocationRelativeTo(owner);
    }

    private void addCampo(String label, JTextField textField, GridBagConstraints gbc, int row) {
        gbc.gridx = 0; gbc.gridy = row;
        add(new JLabel(label), gbc);
        gbc.gridx = 1;
        add(textField, gbc);
    }

    private void aceptar() {
        if (validarCampos()) {
            usuario = new Usuario(nombreField.getText().trim(), apellidoField.getText().trim(),
                                  direccionField.getText().trim(), telefonoField.getText().trim(),
                                  emailField.getText().trim());
            aceptado = true;
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.",
                                          "Error de validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validarCampos() {
        return !nombreField.getText().trim().isEmpty() &&
               !apellidoField.getText().trim().isEmpty() &&
               !direccionField.getText().trim().isEmpty() &&
               !telefonoField.getText().trim().isEmpty() &&
               !emailField.getText().trim().isEmpty();
    }

    private void cancelar() {
        aceptado = false;
        dispose();
    }

    public boolean mostrar() {
        setVisible(true);
        return aceptado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Generador getGenerador() {
        return generador;
    }
}