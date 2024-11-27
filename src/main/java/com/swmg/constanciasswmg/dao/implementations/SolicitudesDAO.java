package com.swmg.constanciasswmg.dao.implementations;

import com.swmg.constanciasswmg.dao.DataAccess;
import com.swmg.constanciasswmg.dao.contracts.ISolicitudesDAO;
import com.swmg.constanciasswmg.pojo.Solicitudes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SolicitudesDAO implements ISolicitudesDAO {
    @Override
    public List<Solicitudes> getAllSolicitudes() throws SQLException { //won't be implemented
        Connection connection = DataAccess.getConnection();

        String query = "select solicitudes.id_solicitud, docentes.nombre as nombre, docentes.apellidos " +
                "as apellidos, tipo_constancias.nombre as tipo_constancia, fecha_solicitud " +
                "from solicitudes left join constancias.docentes on solicitudes.id_docente = docentes.id_docente " +
                "left join tipo_constancias on tipo_constancias.id_tipo_constancias = solicitudes.id_tipo_constancia";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Solicitudes> solicitudesList = new ArrayList<>();
        while (resultSet.next()) {
            Solicitudes solicitudes = new Solicitudes();
            solicitudes.setId(resultSet.getInt("id_solicitud"));
            solicitudes.setNombreDocente(resultSet.getString("nombre"));
            solicitudes.setApellidosDocente(resultSet.getString("apellidos"));
            solicitudes.setFechaSolicitud(resultSet.getDate("fecha_solicitud"));
            solicitudesList.add(solicitudes);
        }

        connection.close();
        return solicitudesList;
    }

    @Override
    public List<Solicitudes> getAllSolicitudesByUserId(int idDocente) throws SQLException {
        Connection connection = DataAccess.getConnection();

        String query = "select solicitudes.id_solicitud, tipo_constancias.nombre as tipo_constancia, " +
                "fecha_solicitud from solicitudes left join tipo_constancias " +
                "on tipo_constancias.id_tipo_constancias = solicitudes.id_tipo_constancia where id_docente = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idDocente);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Solicitudes> solicitudesList = new ArrayList<>();
        while (resultSet.next()) {
            Solicitudes solicitudes = new Solicitudes();
            solicitudes.setFechaSolicitud(resultSet.getDate("fecha_solicitud"));
            solicitudes.setTipoConstancia(resultSet.getString("tipo_constancia"));
            solicitudes.setId(resultSet.getInt("id_solicitud"));
            solicitudesList.add(solicitudes);
        }

        connection.close();
        return solicitudesList;
    }

    @Override
    public int addSolicitud(Solicitudes solicitudes) throws SQLException {
        Connection connection = DataAccess.getConnection();

        String query = "insert into solicitudes(id_tipo_constancia, id_docente, fecha_solicitud) values (?,?,NOW())";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, solicitudes.getIdTipoConstancia());
        preparedStatement.setInt(2, solicitudes.getIdDocente());

        int result;
        result = preparedStatement.executeUpdate();
        connection.close();

        return result;
    }
}
