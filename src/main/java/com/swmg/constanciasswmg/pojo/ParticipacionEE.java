package com.swmg.constanciasswmg.pojo;

public class ParticipacionEE {
    private int id;
    private String nombreEe;
    private int idDocente;
    private String programa;
    private String bloque;

    // Constructor vacío
    public ParticipacionEE() {
    }

    // Constructor parametrizado
    public ParticipacionEE(int id, String nombreEe, int idDocente, String programa, String bloque) {
        this.id = id;
        this.nombreEe = nombreEe;
        this.idDocente = idDocente;
        this.programa = programa;
        this.bloque = bloque;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEe() {
        return nombreEe;
    }

    public void setNombreEe(String nombreEe) {
        this.nombreEe = nombreEe;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    @Override
    public String toString() {
        return "ParticipacionEE{" +
                "id=" + id +
                ", nombreEe='" + nombreEe + '\'' +
                ", idDocente=" + idDocente +
                ", programa='" + programa + '\'' +
                ", bloque='" + bloque + '\'' +
                '}';
    }
}