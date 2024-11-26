package com.swmg.constanciasswmg.dao.contracts;

import java.sql.SQLException;

public interface ICuentaDAO {
    boolean isLoginValid(String user, String password) throws SQLException;
    int getAccountTypeByEmail(String email) throws SQLException;
    int getDocenteIdByEmail(String email) throws SQLException;
}
