package com.swmg.constanciasswmg.dao.contracts;

import com.swmg.constanciasswmg.pojo.Pladea;

import java.sql.SQLException;
import java.util.List;

public interface IPladeaDAO {
    List<Pladea> getPladeaByDocenteId(int idDocente) throws SQLException;
}
