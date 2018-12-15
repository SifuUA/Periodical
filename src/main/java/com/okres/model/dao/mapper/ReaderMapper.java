package com.okres.model.dao.mapper;

import com.okres.model.entity.Reader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class ReaderMapper implements ObjectMapper<Reader> {

    @Override
    public Reader extractFromResultSet(ResultSet rs) throws SQLException {
        Reader reader = new Reader();
        reader.setId(rs.getInt("id"));
        reader.setFirstName(rs.getString("first_name"));
        reader.setId(rs.getInt("id"));
        reader.setId(rs.getInt("id"));
        reader.setId(rs.getInt("id"));

        return reader;
    }

    @Override
    public Reader makeUnique(Map<Integer, Reader> cache, Reader teacher) {
        return null;
    }
}