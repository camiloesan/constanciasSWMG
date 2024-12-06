package com.swmg.constanciasswmg.dao.contracts;

import com.swmg.constanciasswmg.pojo.Proyecto;

import java.sql.SQLException;
import java.util.List;

public interface IProyectoDAO {
    public List<Proyecto> getProyectosByDocenteId(int idDocente) throws SQLException;
}
