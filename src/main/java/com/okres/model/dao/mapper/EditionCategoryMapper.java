package com.okres.model.dao.mapper;

import com.okres.controller.Servlet;
import com.okres.controller.utils.ServletUtility;
import com.okres.model.entity.EditionCategory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import static java.util.Objects.nonNull;

public class EditionCategoryMapper implements ObjectMapper<EditionCategory> {
    @Override
    public EditionCategory extractFromResultSet(ResultSet rs) throws SQLException {

        EditionCategory editionCategory = new EditionCategory();
        editionCategory.setCategoryId(rs.getInt("category_id"));
        if (nonNull(Servlet.langFlag) && Servlet.langFlag.equals("ua"))
            editionCategory.setCategory(rs.getString("category_ua"));
        else
            editionCategory.setCategory(rs.getString("category"));
        return editionCategory;
    }

    @Override
    public EditionCategory makeUnique(Map<Integer, EditionCategory> cache, EditionCategory editionCategory) {

        cache.putIfAbsent(editionCategory.getCategoryId(), editionCategory);
        return cache.get(editionCategory.getCategoryId());
    }
}
