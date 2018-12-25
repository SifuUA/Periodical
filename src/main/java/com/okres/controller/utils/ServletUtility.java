package com.okres.controller.utils;

import com.okres.model.entity.Edition;
import com.okres.model.entity.EditionCategory;
import com.okres.model.service.EditionService;

import javax.servlet.ServletContext;
import java.sql.SQLException;
import java.util.*;

public class ServletUtility {
    private EditionService editionService = new EditionService();

    /*public void setEditionImage(HttpServletRequest request, HttpServletResponse response) {
        @SuppressWarnings("unchecked")
        List<EditionPage> editionList = (List<EditionPage>) request.getSession().getAttribute("editionList");
        List<String> encodeImages = new ArrayList<>();

        for (EditionPage edition : editionList) {
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
        System.out.println(request.getSession().getAttribute("ct"));
        request.getSession().setAttribute("editionCategories", editionCategoryList);

    }*/

    public Map<Edition, String> setEditionImage(ServletContext servletContext) {
        @SuppressWarnings("unchecked")
        List<Edition> editionList = (List<Edition>) servletContext.getAttribute("editionList");
        List<String> encodeImages = new ArrayList<>();
        Map<Edition, String> editionWithImage = new HashMap<>();

        for (Edition edition : editionList) {
            try {
                byte[] imageBytes = edition.getImage().getBytes(1, (int) edition.getImage().length());
                String encode = Base64.getEncoder().encodeToString(imageBytes);
                encodeImages.add(encode);
                editionWithImage.put(edition, encode);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //return encodeImages;
        return editionWithImage;
    }

    public List<EditionCategory> setCategory(ServletContext servletContext) {
        List<EditionCategory> editionCategoryList = editionService.getAllGategories();
        System.out.println(servletContext.getAttribute("ct"));
        return editionCategoryList;
    }
}
