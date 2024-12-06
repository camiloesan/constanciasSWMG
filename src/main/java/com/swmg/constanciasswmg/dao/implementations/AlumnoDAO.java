package com.swmg.constanciasswmg.dao.implementations;

import com.swmg.constanciasswmg.dao.DataAccess;
import com.swmg.constanciasswmg.dao.contracts.IAlumnoDAO;
import com.swmg.constanciasswmg.pojo.Alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO implements IAlumnoDAO {
    public Alumno getAlumnoById(int idAlumno) throws SQLException {
        Connection connection = DataAccess.getConnection();

        String query = "SELECT id_alumno, nombreAlumno FROM alumnos WHERE id_alumno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idAlumno);

        ResultSet resultSet = preparedStatement.executeQuery();
        Alumno alumno = null;

        if (resultSet.next()) {
            alumno = new Alumno();
            alumno.setIdAlumno(resultSet.getInt("id_alumno"));
            alumno.setNombreAlumno(resultSet.getString("nombreAlumno"));
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return alumno;
    }
    public List<Alumno> getAlumnoByProyecto(int idProyecto) throws SQLException {
        Connection connection = DataAccess.getConnection();

        String query = "SELECT a.id_alumno, a.nombreAlumno " +
                "FROM alumnoproyecto ap " +
                "JOIN alumnos a ON ap.id_alumno = a.id_alumno " +
                "WHERE ap.id_proyecto = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idProyecto);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<Alumno> alumnos = new ArrayList<>();
        while (resultSet.next()) {
            Alumno alumno = new Alumno();
            alumno.setIdAlumno(resultSet.getInt("id_alumno"));
            alumno.setNombreAlumno(resultSet.getString("nombreAlumno"));
            alumnos.add(alumno);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return alumnos;
    }
}
