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

    @Override
    public int[] availableKindOfDocument(int idTeacher) throws SQLException {
        Connection connection = DataAccess.getConnection();

        int[] documentTypes = new int[4];

        String queryDocenteProyecto = "SELECT COUNT(*) FROM docenteproyecto WHERE id_docente = ?";
        String queryDocenteTrabajoRecepcional = "SELECT COUNT(*) FROM docentetrabajorecepcional WHERE id_docente = ?";
        String queryParticipacionEE = "SELECT COUNT(*) FROM participacionee WHERE id_docente = ?";
        String queryParticipacionPladea = "SELECT COUNT(*) FROM participacionpladea WHERE id_docente = ?";

        String[] queries = {
                queryDocenteProyecto,
                queryDocenteTrabajoRecepcional,
                queryParticipacionEE,
                queryParticipacionPladea
        };

        for (int i = 0; i < queries.length; i++) {
            PreparedStatement preparedStatement = connection.prepareStatement(queries[i]);
            preparedStatement.setInt(1, idTeacher);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next() && resultSet.getInt(1) > 0) {
                documentTypes[i] = 1;
            }
            resultSet.close();
            preparedStatement.close();
        }

        connection.close();
        return documentTypes;
    }

    @Override
    public String getNombreDeDocenteByID(int idDocente) throws SQLException {
        Connection connection = DataAccess.getConnection();

        String query = "SELECT CONCAT(nombre, ' ', apellidos) AS nombreCompleto FROM docentes WHERE id_docente = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idDocente);

        ResultSet resultSet = preparedStatement.executeQuery();
        String nombreCompleto = null;

        if (resultSet.next()) {
            nombreCompleto = resultSet.getString("nombreCompleto");
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return nombreCompleto;
    }


}
