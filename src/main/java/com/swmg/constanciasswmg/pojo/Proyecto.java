package com.swmg.constanciasswmg.pojo;

public class Proyecto {
    private int idProyecto;
    private String nombreProyecto;
    private String duracion;
    private String lugar;

    // Constructor vacío
    public Proyecto() {
    }

    // Constructor parametrizado
    public Proyecto(int idProyecto, String nombreProyecto, String duracion, String lugar) {
        this.idProyecto = idProyecto;
        this.nombreProyecto = nombreProyecto;
        this.duracion = duracion;
        this.lugar = lugar;
    }

    // Getters y Setters
    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "idProyecto=" + idProyecto +
                ", nombreProyecto='" + nombreProyecto + '\'' +
                ", duracion='" + duracion + '\'' +
                ", lugar='" + lugar + '\'' +
                '}';
    }
}
