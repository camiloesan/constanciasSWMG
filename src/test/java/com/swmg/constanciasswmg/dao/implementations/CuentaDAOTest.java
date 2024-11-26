package com.swmg.constanciasswmg.dao.implementations;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class CuentaDAOTest {

    @Test
    void getDocenteIdByEmail() {
        CuentaDAO cuentaDAO = new CuentaDAO();

        int result = 0;
        try {
            result = cuentaDAO.getDocenteIdByEmail("skfjld@gmail.com");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        assertEquals(1, result);
    }
}