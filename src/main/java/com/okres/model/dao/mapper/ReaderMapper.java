package com.okres.model.dao.mapper;

import com.okres.model.entity.Reader;
import com.okres.model.entity.enums.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class ReaderMapper implements ObjectMapper<Reader> {

    @Override
    public Reader extractFromResultSet(ResultSet rs) throws SQLException {

        Reader reader = new Reader();
        reader.setId(rs.getInt("id"));
        reader.setFirstName(rs.getString("first_name"));
        reader.setPhoneNumber(rs.getInt("phone_number"));
        reader.setEmailAddress(rs.getString("email"));
        reader.setPassword(rs.getString("password"));
        return reader;
    }

    @Override
    public Reader makeUnique(Map<Integer, Reader> cache, Reader reader) {

        cache.putIfAbsent(reader.getId(),reader);
        return cache.get(reader.getId());
    }
}
