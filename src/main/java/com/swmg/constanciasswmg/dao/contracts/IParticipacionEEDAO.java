package com.swmg.constanciasswmg.dao.contracts;

import com.swmg.constanciasswmg.pojo.ParticipacionEE;

import java.sql.SQLException;
import java.util.List;

public interface IParticipacionEEDAO {
    public List<ParticipacionEE> getParticipacionesByDocenteId(int idDocente) throws SQLException;
}
