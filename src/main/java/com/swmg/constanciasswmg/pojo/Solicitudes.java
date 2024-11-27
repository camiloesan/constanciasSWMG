package com.swmg.constanciasswmg.pojo;

import java.sql.Date;

public class Solicitudes {
    private int id;
    private int idTipoConstancia;
    private String tipoConstancia;
    private int idDocente;
    private String nombreDocente;
    private String apellidosDocente;
    private Date fechaSolicitud;

    public Solicitudes() {

    }

    public Solicitudes(int id, int idTipoConstancia, int idDocente, String nombreDocente, String apellidosDocente, Date fechaSolicitud) {
        this.id = id;
        this.idTipoConstancia = idTipoConstancia;
        this.idDocente = idDocente;
        this.nombreDocente = nombreDocente;
        this.apellidosDocente = apellidosDocente;
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getTipoConstancia() {
        return tipoConstancia;
    }

    public void setTipoConstancia(String tipoConstancia) {
        this.tipoConstancia = tipoConstancia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }

    public String getApellidosDocente() {
        return apellidosDocente;
    }

    public void setApellidosDocente(String apellidosDocente) {
        this.apellidosDocente = apellidosDocente;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTipoConstancia() {
        return idTipoConstancia;
    }

    public void setIdTipoConstancia(int idTipoConstancia) {
        this.idTipoConstancia = idTipoConstancia;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }
}
