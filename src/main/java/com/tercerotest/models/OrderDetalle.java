package com.tercerotest.models;

public class OrderDetalle {
    private Integer id;
    private Integer cant;
    private Float pu;
    private Float pt;
    private Integer id_order;
    private Integer id_service;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCant() {
        return this.cant;
    }

    public void setCant(Integer cant) {
        this.cant = cant;
    }

    public Float getPu() {
        return this.pu;
    }

    public void setPu(Float pu) {
        this.pu = pu;
    }

    public Float getPt() {
        return this.pt;
    }

    public void setPt(Float pt) {
        this.pt = pt;
    }

    public Integer getId_order() {
        return this.id_order;
    }

    public void setId_order(Integer id_order) {
        this.id_order = id_order;
    }

    public Integer getId_service() {
        return this.id_service;
    }

    public void setId_service(Integer id_service) {
        this.id_service = id_service;
    }

}
