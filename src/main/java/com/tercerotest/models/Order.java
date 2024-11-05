package com.tercerotest.models;

import java.util.Date;

public class Order {
    private Integer id;
    private Date fecha;
    private Float subtotal;
    private Float iva;
    private Float total;
    private String nro_order;
    private Integer id_persona;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Float getSubtotal() {
        return this.subtotal;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }

    public Float getIva() {
        return this.iva;
    }

    public void setIva(Float iva) {
        this.iva = iva;
    }

    public Float getTotal() {
        return this.total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getNro_order() {
        return this.nro_order;
    }

    public void setNro_order(String nro_order) {
        this.nro_order = nro_order;
    }

    public Integer getId_persona() {
        return this.id_persona;
    }

    public void setId_persona(Integer id_persona) {
        this.id_persona = id_persona;
    }

}
