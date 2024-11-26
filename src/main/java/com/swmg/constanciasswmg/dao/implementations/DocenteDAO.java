package com.swmg.constanciasswmg.dao.implementations;

import com.swmg.constanciasswmg.dao.DataAccess;
import com.swmg.constanciasswmg.dao.contracts.IDocenteDAO;
import com.swmg.constanciasswmg.pojo.Docente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DocenteDAO implements IDocenteDAO {
    @Override
    public boolean addProfessor(Docente docente) throws SQLException {
        Connection connection = DataAccess.getConnection();

        String queryCuenta = "insert into cuentas(id_tipo_cuenta, email, contrasena, no_trabajador) values(?,?,?,?)";
        PreparedStatement preparedStatementCuenta = connection.prepareStatement(queryCuenta);
        preparedStatementCuenta.setInt(1, 2);
        preparedStatementCuenta.setString(2, docente.getEmail());
        preparedStatementCuenta.setString(3, "aaa");
        Random random = new Random();
        int noTrabajador = random.nextInt(1000000) + 1;
        preparedStatementCuenta.setInt(4, noTrabajador);
        int resultCuenta  = preparedStatementCuenta.executeUpdate();

        String queryId = "select id_cuenta from cuentas where email = ?";
        PreparedStatement preparedStatementId = connection.prepareStatement(queryId);
        preparedStatementId.setString(1, docente.getEmail());
        ResultSet resultSetId = preparedStatementId.executeQuery();
        if (resultSetId.next()) {
            docente.setIdCuenta(resultSetId.getInt(1));
        }

        String query = "insert into docentes(id_cuenta, nombre, apellidos, telefono, firma_digital) " +
                "values(?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, docente.getIdCuenta());
        preparedStatement.setString(2, docente.getNombre());
        preparedStatement.setString(3, docente.getApellidos());
        preparedStatement.setString(4, docente.getTelefono());
        preparedStatement.setString(5, docente.getFirma_digital());

        int result = preparedStatement.executeUpdate();
        connection.close();

        return result == 1 && resultCuenta == 1;
    }

    @Override
    public List<Docente> selectAll() throws SQLException {
        Connection connection = DataAccess.getConnection();

        String query = "select id_docente, cuentas.no_trabajador as no_trabajador, cuentas.email as email, nombre, apellidos, telefono, firma_digital " +
                "from docentes join cuentas on docentes.id_cuenta = cuentas.id_cuenta";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Docente> docentes = new ArrayList<>();
        while (resultSet.next()) {
            Docente docente = new Docente();
            docente.setId(resultSet.getInt("id_docente"));
            docente.setNoTrabajador(resultSet.getString("no_trabajador"));
            docente.setEmail(resultSet.getString("email"));
            docente.setNombre(resultSet.getString("nombre"));
            docente.setApellidos(resultSet.getString("apellidos"));
            docente.setTelefono(resultSet.getString("telefono"));
            docente.setFirma_digital(resultSet.getString("firma_digital"));
            docentes.add(docente);
        }
        connection.close();

        return docentes;
    }
}
