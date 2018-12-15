package com.okres.model.dao.mapper;

import com.okres.model.entity.EditionCategory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class EditionCategoryMapper implements ObjectMapper<EditionCategory> {
    @Override
    public EditionCategory extractFromResultSet(ResultSet rs) throws SQLException {

        EditionCategory editionCategory = new EditionCategory();
        editionCategory.setCategoryId(rs.getInt("category_id"));
        editionCategory.setCategory(rs.getString("category"));
        return editionCategory;
    }

    @Override
    public EditionCategory makeUnique(Map<Integer, EditionCategory> cache, EditionCategory editionCategory) {

        cache.putIfAbsent(editionCategory.getCategoryId(), editionCategory);
        return cache.get(editionCategory.getCategoryId());
    }
}
