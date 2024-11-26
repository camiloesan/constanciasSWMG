package com.swmg.constanciasswmg.dao.implementations;

import com.swmg.constanciasswmg.dao.DataAccess;
import com.swmg.constanciasswmg.dao.contracts.ITiposConstanciasDAO;
import com.swmg.constanciasswmg.pojo.TipoConstancias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TiposConstanciasDAO implements ITiposConstanciasDAO {
    @Override
    public List<TipoConstancias> getTiposConstancias() throws SQLException {
        Connection connection = DataAccess.getConnection();

        String query = "select id_tipo_constancias, nombre from tipo_constancias";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<TipoConstancias> tiposConstanciasList = new ArrayList<>();
        while (resultSet.next()) {
            TipoConstancias tipoConstancias = new TipoConstancias();
            tipoConstancias.setIdTipoConstancia(resultSet.getInt("id_tipo_constancias"));
            tipoConstancias.setNombreTipoConstancia(resultSet.getString("nombre"));

            tiposConstanciasList.add(tipoConstancias);
        }

        connection.close();
        return tiposConstanciasList;
    }
}
