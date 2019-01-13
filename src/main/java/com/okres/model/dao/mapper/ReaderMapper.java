package com.okres.model.dao.mapper;

import com.okres.model.entity.Reader;
import com.okres.model.entity.enums.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */

public class ReaderMapper implements ObjectMapper<Reader> {

    @Override
    public Reader extractFromResultSet(ResultSet rs) throws SQLException {
        Reader reader = new Reader();
        reader.setId(rs.getInt("id"));
        reader.setFirstName(rs.getString("first_name"));
        reader.setLastName(rs.getString("last_name"));
        reader.setPhoneNumber(rs.getString("phone_number"));
        reader.setEmailAddress(rs.getString("email"));
        reader.setPassword(rs.getString("password"));
        reader.setRole(rs.getInt("role_id") == 1 ? Role.ADMIN : Role.READER);
        return reader;
    }
}
