package com.swmg.constanciasswmg.pojo;

public class Docente {
    private int id;
    private int idCuenta;
    private String nombre;
    private String email;
    private String apellidos;
    private String telefono;
    private String firma_digital;
    private String noTrabajador;
    private String contrasena;

    public Docente() {}

    public Docente(int id, int idCuenta, String nombre, String email, String apellidos, String telefono, String firma_digital) {
        this.id = id;
        this.idCuenta = idCuenta;
        this.nombre = nombre;
        this.email = email;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.firma_digital = firma_digital;
    }

    public String getNoTrabajador() {
        return noTrabajador;
    }

    public void setNoTrabajador(String noTrabajador) {
        this.noTrabajador = noTrabajador;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFirma_digital() {
        return firma_digital;
    }

    public void setFirma_digital(String firma_digital) {
        this.firma_digital = firma_digital;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
