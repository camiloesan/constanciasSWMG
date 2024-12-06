package com.swmg.constanciasswmg.dao.implementations;

import com.swmg.constanciasswmg.dao.DataAccess;
import com.swmg.constanciasswmg.dao.contracts.IParticipacionEEDAO;
import com.swmg.constanciasswmg.pojo.ParticipacionEE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParticipacionEEDAO implements IParticipacionEEDAO {

    public List<ParticipacionEE> getParticipacionesByDocenteId(int idDocente) throws SQLException {
        Connection connection = DataAccess.getConnection();

        String query = "SELECT id, nombreEe, programa, bloque " +
                "FROM participacionEE " +
                "WHERE id_docente = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idDocente);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<ParticipacionEE> participaciones = new ArrayList<>();
        while (resultSet.next()) {
            ParticipacionEE participacionEE = new ParticipacionEE();
            participacionEE.setId(resultSet.getInt("id"));
            participacionEE.setNombreEe(resultSet.getString("nombreEe"));
            participacionEE.setPrograma(resultSet.getString("programa"));
            participacionEE.setBloque(resultSet.getString("bloque"));
            participaciones.add(participacionEE);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return participaciones;
    }
}
