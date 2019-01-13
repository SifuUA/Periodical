package com.okres.controller.utils;
/**
 * @author O.Kres
 * @project Periodical
 * @version 1.0
 * @since 1/13/2019
 */

import com.okres.model.entity.Edition;
import com.okres.model.entity.EditionCategory;
import com.okres.model.service.EditionService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.*;

import static java.util.Objects.nonNull;

public class ServletUtility {
    private EditionService editionService = new EditionService();

    /**
     * Method for encode image from DB and put in map
     *
     * @param servletContext because method start in method init must work with ServletContext
     * @return all encoded editions objects from DB
     * @see com.okres.controller.Servlet#init(ServletConfig)
     */
    public Map<Edition, String> setEditionImage(ServletContext servletContext) {
        @SuppressWarnings("unchecked")
        List<Edition> editionList = (List<Edition>) servletContext.getAttribute("editionList");
        Map<Edition, String> editionWithImage = new HashMap<>();

        for (Edition edition : editionList) {
            try {
                byte[] imageBytes = edition.getImage().getBytes(1, (int) edition.getImage().length());
                String encode = Base64.getEncoder().encodeToString(imageBytes);
                editionWithImage.put(edition, encode);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return editionWithImage;
    }

    /**
     * Implemented for button of sorting by category on page
     *
     * @return list of edition categories objects getting from DB
     */
    public List<EditionCategory> setCategory(ServletContext servletContext) {
        return editionService.getAllGategories();
    }

    /**
     * Method get images for current page from pagination on page
     *
     * @param start          a reference point for visualization images
     * @param recordsPerPage count of editions per page
     * @return Map key of Editions objects and values of decoding images from DB
     */
    public Map<Edition, String> getLimitEditionImage(HttpServletRequest request, int start, int recordsPerPage) {
        String currentCategory = request.getParameter("catId");
        boolean categoryFlag = false;
        int category = 0;
        int counter = 0;
        if (currentCategory != null) {
            categoryFlag = true;
            category = Integer.parseInt(currentCategory);
        }
        Map<Edition, String> encodeImages = (Map<Edition, String>) request.getServletContext().getAttribute("encodeImages");
        Map<Edition, String> resultEditionImage = new HashMap<>();
        for (Map.Entry<Edition, String> map : encodeImages.entrySet()) {
            if (counter >= start && recordsPerPage > 0) {
                if (categoryFlag && map.getKey().getCategory() == category) {
                    resultEditionImage.put(map.getKey(), map.getValue());
                    recordsPerPage--;
                } else if (!categoryFlag) {
                    resultEditionImage.put(map.getKey(), map.getValue());
                    recordsPerPage--;
                }
            }
            counter++;
        }
        return resultEditionImage;
    }

    /**
     * Service method for correct visualization chosen edition on page and set
     * information to the session about editions
     */
    public boolean getCurrentImages(HttpServletRequest request) {
        int rows = editionService.getNoOfRecords();
        int page = 1;
        int recordsPerPage = 12;
        int noOfPages = (int) Math.ceil(rows * 1.0 / recordsPerPage);
        if (nonNull(request.getParameter("page"))) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        Map<Edition, String> limitEditionImage = getLimitEditionImage(request, (page - 1) * recordsPerPage, recordsPerPage);
        request.getSession().setAttribute("encodeImages", limitEditionImage);
        request.getSession().setAttribute("numberOfPages", noOfPages);
        request.getSession().setAttribute("currentPage", page);
        String index = request.getParameter("imageIndex");
        request.getSession().setAttribute("imageIndex", index);
        return index != null;
    }
}
