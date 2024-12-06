package com.swmg.constanciasswmg.dao.contracts;

import com.swmg.constanciasswmg.pojo.Alumno;

import java.sql.SQLException;
import java.util.List;

public interface IAlumnoDAO {
    public Alumno getAlumnoById(int idAlumno) throws SQLException;
    public List<Alumno> getAlumnoByProyecto(int idProyecto) throws SQLException;
}
