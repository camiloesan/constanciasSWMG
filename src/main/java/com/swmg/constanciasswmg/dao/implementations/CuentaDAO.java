package com.swmg.constanciasswmg.dao.implementations;

import com.swmg.constanciasswmg.dao.DataAccess;
import com.swmg.constanciasswmg.dao.contracts.ICuentaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CuentaDAO implements ICuentaDAO {
    @Override
    public boolean isLoginValid(String email, String password) throws SQLException {
        Connection connection = DataAccess.getConnection();

        String query = "select 1 from cuentas where email = ? and contrasena = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, email);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();

        boolean result = resultSet.next();

        connection.close();

        return result;
    }

    @Override
    public int getAccountTypeByEmail(String email) throws SQLException {
        Connection connection = DataAccess.getConnection();
        String query = "select id_tipo_cuenta from cuentas where email = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, email);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        int result = resultSet.getInt("id_tipo_cuenta");

        connection.close();

        return result;
    }

    @Override
    public int getDocenteIdByEmail(String email) throws SQLException {
        Connection connection = DataAccess.getConnection();
        String query = "select docentes.id_docente as id_docente from cuentas join docentes where email = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, email);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        int result = resultSet.getInt("id_docente");

        connection.close();
        return result;
    }
}
