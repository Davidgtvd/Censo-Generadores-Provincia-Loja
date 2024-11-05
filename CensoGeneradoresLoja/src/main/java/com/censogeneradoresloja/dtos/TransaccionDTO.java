/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja.dtos;

/**
 *
 * @author david
 */
import lombok.Data;

import java.util.Date;

@Data
public class TransaccionDTO {
    private String id;
    private String generadorId;
    private String usuarioId;
    private Date fechaTransaccion;
    private double costo;
    private String estado;

    public TransaccionDTO(String id, String generadorId, String usuarioId, Date fechaTransaccion,
                          double costo, String estado) {
        this.id = id;
        this.generadorId = generadorId;
        this.usuarioId = usuarioId;
        this.fechaTransaccion = fechaTransaccion;
        this.costo = costo;
        this.estado = estado;
    }
}