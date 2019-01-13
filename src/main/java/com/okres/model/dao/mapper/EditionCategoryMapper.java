package com.okres.model.dao.mapper;

import com.okres.controller.Servlet;
import com.okres.model.entity.EditionCategory;

import java.sql.ResultSet;
import java.sql.SQLException;

import static java.util.Objects.nonNull;

/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */

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
}
