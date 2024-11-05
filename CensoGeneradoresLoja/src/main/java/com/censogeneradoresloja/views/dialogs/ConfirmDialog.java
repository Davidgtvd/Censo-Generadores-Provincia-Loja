/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja.views.dialogs;

/**
 *
 * @author david
 */
import javax.swing.*;
import java.awt.*;

public class ConfirmDialog extends JDialog {
    private boolean confirmado = false;

    public ConfirmDialog(Window owner, String mensaje) {
        super(owner, "Confirmación", ModalityType.APPLICATION_MODAL);
        setLayout(new BorderLayout());

        JLabel mensajeLabel = new JLabel(mensaje);
        mensajeLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(mensajeLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton siButton = new JButton("Sí");
        JButton noButton = new JButton("No");

        siButton.addActionListener(e -> {
            confirmado = true;
            dispose();
        });

        noButton.addActionListener(e -> {
            confirmado = false;
            dispose();
        });

        buttonPanel.add(siButton);
        buttonPanel.add(noButton);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(owner);
    }

    public boolean mostrar() {
        setVisible(true);
        return confirmado;
    }
}