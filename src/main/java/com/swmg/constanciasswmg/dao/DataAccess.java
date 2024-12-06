package com.swmg.constanciasswmg.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataAccess {
    static final String URL = "jdbc:mysql://localhost:3306/constancias";
    static final String USER = "ConstanciasUser";
    static final String PASSWORD = "Contrasenia123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
