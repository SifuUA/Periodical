package com.okres.model.dao.mapper;

import com.okres.model.entity.Edition;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class EditionMapper implements ObjectMapper<Edition> {

    @Override
    public Edition extractFromResultSet(ResultSet rs) throws SQLException {
        return null;
    }

    @Override
    public Edition makeUnique(Map<Integer, Edition> cache, Edition teacher) {
        return null;
    }
}
