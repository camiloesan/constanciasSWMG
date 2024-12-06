package com.swmg.constanciasswmg.dao.contracts;

import com.swmg.constanciasswmg.pojo.Docente;

import java.sql.SQLException;
import java.util.List;

public interface IDocenteDAO {
    boolean addProfessor(Docente docente) throws SQLException;
    List<Docente> selectAll() throws SQLException;
    int[] availableKindOfDocument(int idTeacher) throws SQLException;

    String getNombreDeDocenteByID(int idDocente) throws SQLException;
}
