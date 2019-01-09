package com.okres.controller.utils;

import com.okres.model.entity.Edition;
import com.okres.model.entity.EditionCategory;
import com.okres.model.service.EditionService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.*;

public class ServletUtility {
    private EditionService editionService = new EditionService();

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
        return editionCategoryList;
    }

    public List<Edition> viewAllEditions(int start, int recordsPerPage, HttpServletRequest request) {
        int counter = 0;

        List<Edition> editionList = (List<Edition>) request.getServletContext().getAttribute("editionList");
        List<Edition> resultList = new ArrayList<>();

        for (Edition edition : editionList) {
            if (counter >= start && recordsPerPage > 0) {
                resultList.add(edition);
                recordsPerPage--;
            }
            counter++;
        }
        return resultList;
    }

    public Map<Edition, String> getLimitEditionImage(HttpServletRequest request, int start, int recordsPerPage) {
        Map<Edition, String> encodeImages = (Map<Edition, String>) request.getServletContext().getAttribute("encodeImages");
        Map<Edition, String> resultEditionImage = new HashMap<>();
        int counter = 0;

        for (Map.Entry<Edition, String> map : encodeImages.entrySet()) {
            if (counter >= start && recordsPerPage > 0) {
                resultEditionImage.put(map.getKey(), map.getValue());
                recordsPerPage--;
            }
            counter++;
        }

        return resultEditionImage;
    }

    public boolean getCurrentImages(HttpServletRequest request) {

        int rows = editionService.getNoOfRecords();
        int page = 1;
        int recordsPerPage = 12;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        int noOfPages = (int) Math.ceil(rows * 1.0 / recordsPerPage);
        Map<Edition, String> limitEditionImage = getLimitEditionImage(request, (page - 1) * recordsPerPage, recordsPerPage);
        request.getSession().setAttribute("encodeImages", limitEditionImage);
        request.getSession().setAttribute("numberOfPages", noOfPages);
        request.getSession().setAttribute("currentPage", page);

        String index = request.getParameter("editionIndex");
        if (index != null) {
            System.out.println(index);
            request.getSession().setAttribute("editionIndex", index);
            return true;
        }
        return false;
    }
}
