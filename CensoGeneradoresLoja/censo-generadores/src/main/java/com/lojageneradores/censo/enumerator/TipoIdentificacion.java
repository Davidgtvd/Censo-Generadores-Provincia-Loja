package com.lojageneradores.censo.enumerator;

public enum TipoIdentificacion {
    CEDULA("Cédula de Identidad"),
    PASAPORTE("Pasaporte"),
    RUC("RUC");

    private String descripcion;

    // Constructor
    TipoIdentificacion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Getter
    public String getDescripcion() {
        return descripcion;
    }

    // Método para obtener un TipoIdentificacion por descripción
    public static TipoIdentificacion getByDescripcion(String descripcion) {
        for (TipoIdentificacion tipo : TipoIdentificacion.values()) {
            if (tipo.getDescripcion().equalsIgnoreCase(descripcion)) {
                return tipo;
            }
        }
        return null;
    }
}
