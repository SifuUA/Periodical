package com.okres.model.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */

public interface ObjectMapper<T> {
    T extractFromResultSet(ResultSet rs) throws SQLException;
}
