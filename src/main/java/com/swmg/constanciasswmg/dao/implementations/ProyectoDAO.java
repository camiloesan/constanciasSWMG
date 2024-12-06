package com.swmg.constanciasswmg.dao.implementations;

import com.swmg.constanciasswmg.dao.DataAccess;
import com.swmg.constanciasswmg.dao.contracts.IProyectoDAO;
import com.swmg.constanciasswmg.pojo.Proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProyectoDAO implements IProyectoDAO {
    public List<Proyecto> getProyectosByDocenteId(int idDocente) throws SQLException {
        Connection connection = DataAccess.getConnection();

        String query = "SELECT p.id_proyecto, p.nombreProyecto, p.duracion, p.lugar " +
                "FROM docenteProyecto dp " +
                "LEFT JOIN proyecto p ON dp.id_proyecto = p.id_proyecto " +
                "WHERE dp.id_docente = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idDocente);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<Proyecto> proyectos = new ArrayList<>();
        while (resultSet.next()) {
            Proyecto proyecto = new Proyecto();
            proyecto.setIdProyecto(resultSet.getInt("id_proyecto"));
            proyecto.setNombreProyecto(resultSet.getString("nombreProyecto"));
            proyecto.setDuracion(resultSet.getString("duracion"));
            proyecto.setLugar(resultSet.getString("lugar"));
            proyectos.add(proyecto);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return proyectos;
    }
}
