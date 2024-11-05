package com.tercerotest.models.enumerator;

public enum TipoEquipo {
    PORTATIL("PORTATIL"), ESCRITORIO("ESCRITORIO"), CELULAR("CELULAR"), CARGADOR("CARGADOR"), CPU("CPU"), MONITOR("MONITOR");
    private String name;

    TipoEquipo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
