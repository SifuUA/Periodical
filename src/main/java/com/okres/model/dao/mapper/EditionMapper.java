package com.okres.model.dao.mapper;

import com.okres.model.entity.Edition;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */

public class EditionMapper implements ObjectMapper<Edition> {

    @Override
    public Edition extractFromResultSet(ResultSet rs) throws SQLException {
        Edition edition = new Edition();
        edition.setId(rs.getInt("id"));
        edition.setEditionName(rs.getString("name"));
        edition.setCategory(rs.getInt("category_id"));
        edition.setImage(rs.getBlob("image"));
        edition.setPrice(rs.getInt("price"));
        edition.setNotation(rs.getString("notation"));
        return edition;
    }
}
