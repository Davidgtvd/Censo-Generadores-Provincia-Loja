package com.lojageneradores.censo.enumerator;

public enum TipoEquipo {
    GENERADOR_ELECTRICO("Generador Eléctrico"),
    GENERADOR_EOLICO("Generador Eólico"),
    GENERADOR_SOLAR("Generador Solar");

    private String nombre;

    // Constructor
    TipoEquipo(String nombre) {
        this.nombre = nombre;
    }

    // Getter
    public String getNombre() {
        return nombre;
    }

    // Método para obtener un TipoEquipo por nombre
    public static TipoEquipo getByNombre(String nombre) {
        for (TipoEquipo tipo : TipoEquipo.values()) {
            if (tipo.getNombre().equalsIgnoreCase(nombre)) {
                return tipo;
            }
        }
        return null;
    }
}
