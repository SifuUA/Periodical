package com.okres.controller.utils;

import com.okres.model.entity.Edition;
import com.okres.model.entity.EditionCategory;
import com.okres.model.service.EditionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.*;

public class ServletUtility {
    EditionService editionService  = new EditionService();

    public void setEditionImage(HttpServletRequest request, HttpServletResponse response) {
        List<Edition> editionList = (List<Edition>) request.getServletContext().getAttribute("editionList");
        List<String> encodeImages = new ArrayList<>();

        for (Edition edition : editionList) {
            try {

                byte[] imageBytes = edition.getImage().getBytes(1, (int) edition.getImage().length());
                String encode = Base64.getEncoder().encodeToString(imageBytes);
                encodeImages.add(encode);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        request.getSession().setAttribute("encodeImages", encodeImages);
    }

    public void setCategory(HttpServletRequest request, HttpServletResponse response) {
        List<EditionCategory> editionCategoryList = editionService.getAllGategories();
        request.getSession().setAttribute("editionCategories", editionCategoryList);

    }
}
