package com.swmg.constanciasswmg.dao.contracts;

import com.swmg.constanciasswmg.pojo.Solicitudes;

import java.sql.SQLException;
import java.util.List;

public interface ISolicitudesDAO {
    List<Solicitudes> getAllSolicitudes() throws SQLException;
    List<Solicitudes> getAllSolicitudesByUserId(int idDocente) throws SQLException;
    int addSolicitud(Solicitudes solicitudes) throws SQLException;
}
