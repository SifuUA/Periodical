package com.okres.model.dao.mapper;

import com.okres.model.entity.Edition;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

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

    @Override
    public Edition makeUnique(Map<Integer, Edition> cache, Edition edition) {

        cache.putIfAbsent(edition.getId(), edition);
        return cache.get(edition.getId());
    }
}
