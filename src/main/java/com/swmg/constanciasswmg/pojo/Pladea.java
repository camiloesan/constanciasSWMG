package com.swmg.constanciasswmg.pojo;

public class Pladea {
    private int idPladea;
    private String ejeEstrategico;
    private String nombrePrograma;
    private String objetivosGenerales;
    private String acciones;
    private String metas;

    // Constructor vacío
    public Pladea() {
    }

    // Constructor con parámetros
    public Pladea(int idPladea, String ejeEstrategico, String nombrePrograma, String objetivosGenerales, String acciones, String metas) {
        this.idPladea = idPladea;
        this.ejeEstrategico = ejeEstrategico;
        this.nombrePrograma = nombrePrograma;
        this.objetivosGenerales = objetivosGenerales;
        this.acciones = acciones;
        this.metas = metas;
    }

    // Getters y Setters
    public int getIdPladea() {
        return idPladea;
    }

    public void setIdPladea(int idPladea) {
        this.idPladea = idPladea;
    }

    public String getEjeEstrategico() {
        return ejeEstrategico;
    }

    public void setEjeEstrategico(String ejeEstrategico) {
        this.ejeEstrategico = ejeEstrategico;
    }

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }

    public String getObjetivosGenerales() {
        return objetivosGenerales;
    }

    public void setObjetivosGenerales(String objetivosGenerales) {
        this.objetivosGenerales = objetivosGenerales;
    }

    public String getAcciones() {
        return acciones;
    }

    public void setAcciones(String acciones) {
        this.acciones = acciones;
    }

    public String getMetas() {
        return metas;
    }

    public void setMetas(String metas) {
        this.metas = metas;
    }

    @Override
    public String toString() {
        return "Pladea{" +
                "idPladea=" + idPladea +
                ", ejeEstrategico='" + ejeEstrategico + '\'' +
                ", nombrePrograma='" + nombrePrograma + '\'' +
                ", objetivosGenerales='" + objetivosGenerales + '\'' +
                ", acciones='" + acciones + '\'' +
                ", metas='" + metas + '\'' +
                '}';
    }
}
