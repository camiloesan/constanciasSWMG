package com.swmg.constanciasswmg.pojo;

public class TipoConstancias {
    private int idTipoConstancia;
    private String nombreTipoConstancia;

    public TipoConstancias() {}

    public TipoConstancias(int idTipoConstancia, String nombreTipoConstancia) {
        this.idTipoConstancia = idTipoConstancia;
        this.nombreTipoConstancia = nombreTipoConstancia;
    }

    public int getIdTipoConstancia() {
        return idTipoConstancia;
    }

    public void setIdTipoConstancia(int idTipoConstancia) {
        this.idTipoConstancia = idTipoConstancia;
    }

    public String getNombreTipoConstancia() {
        return nombreTipoConstancia;
    }

    public void setNombreTipoConstancia(String nombreTipoConstancia) {
        this.nombreTipoConstancia = nombreTipoConstancia;
    }
}
