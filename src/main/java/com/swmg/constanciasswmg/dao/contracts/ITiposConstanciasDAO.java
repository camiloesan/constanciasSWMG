package com.swmg.constanciasswmg.dao.contracts;

import com.swmg.constanciasswmg.pojo.TipoConstancias;

import java.sql.SQLException;
import java.util.List;

public interface ITiposConstanciasDAO {
    List<TipoConstancias> getTiposConstancias() throws SQLException;
}
