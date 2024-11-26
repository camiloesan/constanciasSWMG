package com.swmg.constanciasswmg.dao;

import com.swmg.constanciasswmg.dao.implementations.TiposConstanciasDAO;
import com.swmg.constanciasswmg.pojo.TipoConstancias;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TiposConstanciasDAOTest {

    @Test
    void getTiposConstancias() {
        TiposConstanciasDAO tiposConstanciasDAO = new TiposConstanciasDAO();

        List<TipoConstancias> result;
        try {
            result = tiposConstanciasDAO.getTiposConstancias();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        assertNotNull(result);
    }
}