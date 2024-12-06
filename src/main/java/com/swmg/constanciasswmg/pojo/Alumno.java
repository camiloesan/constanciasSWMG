package com.swmg.constanciasswmg.pojo;

public class Alumno {
    private int idAlumno;
    private String nombreAlumno;

    // Constructor vacío
    public Alumno() {
    }

    // Constructor parametrizado
    public Alumno(int idAlumno, String nombreAlumno) {
        this.idAlumno = idAlumno;
        this.nombreAlumno = nombreAlumno;
    }

    // Getters y Setters
    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "idAlumno=" + idAlumno +
                ", nombreAlumno='" + nombreAlumno + '\'' +
                '}';
    }
}
