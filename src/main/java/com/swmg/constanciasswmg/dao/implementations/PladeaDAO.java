package com.swmg.constanciasswmg.dao.implementations;


import com.swmg.constanciasswmg.dao.DataAccess;
import com.swmg.constanciasswmg.dao.contracts.IPladeaDAO;
import com.swmg.constanciasswmg.pojo.Pladea;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import java.sql.SQLException;
import java.util.List;

public class PladeaDAO implements IPladeaDAO{

    @Override
    public List<Pladea> getPladeaByDocenteId(int idDocente) throws SQLException {
        Connection connection = DataAccess.getConnection();

        String query = "SELECT p.id_pladea, p.EjeEstrategico, p.NombrePrograma, p.ObjetivosGenerales, p.Acciones, p.Metas " +
                "FROM participacionPladea pp " +
                "LEFT JOIN pladea p ON pp.id_pladea = p.id_pladea " +
                "WHERE pp.id_docente = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idDocente);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<Pladea> pladeaList = new ArrayList<>();
        while (resultSet.next()) {
            Pladea pladea = new Pladea();
            pladea.setIdPladea(resultSet.getInt("id_pladea"));
            pladea.setEjeEstrategico(resultSet.getString("EjeEstrategico"));
            pladea.setNombrePrograma(resultSet.getString("NombrePrograma"));
            pladea.setObjetivosGenerales(resultSet.getString("ObjetivosGenerales"));
            pladea.setAcciones(resultSet.getString("Acciones"));
            pladea.setMetas(resultSet.getString("Metas"));
            pladeaList.add(pladea);
        }

        connection.close();
        return pladeaList;
    }
}
