package com.okres.controller.command;

import com.okres.controller.utils.ServletUtility;
import com.okres.model.entity.Edition;
import com.okres.model.entity.enums.Role;
import com.okres.model.service.EditionService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */

public class MainPage implements Command {
    private static Logger logger = Logger.getLogger(MainPage.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        EditionService editionService = new EditionService();
        int rows = editionService.getNoOfRecords();
        ServletUtility servletUtility = new ServletUtility();

        int page = 1;
        int recordsPerPage = 12;
        int noOfPages = (int) Math.ceil(rows * 1.0 / recordsPerPage);
        logger.info("Number rof page: " + noOfPages);
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        Map<Edition, String> limitEditionImage =
                servletUtility.getLimitEditionImage(request, (page - 1) * recordsPerPage, recordsPerPage);
        request.getSession().setAttribute("encodeImages", limitEditionImage);
        if (nonNull(request.getParameter("catId")))
            noOfPages = (int) Math.ceil(limitEditionImage.size() * 1.0 / recordsPerPage);
        request.getSession().setAttribute("numberOfPages", noOfPages);
        request.getSession().setAttribute("currentPage", page);
        request.getServletContext().setAttribute("editionCategories", servletUtility.setCategory(request.getServletContext()));
        String index = request.getParameter("imageIndex");
        request.getSession().setAttribute("imageIndex", index);
        logger.debug("Image index: " + index);
        return getPath(request, index);
    }

    /**
     * Mapper for role - path (main page for role)
     *
     * @param index for find image and show on page
     * @return corresponding role page
     */
    private String getPath(HttpServletRequest request, String index) {
        HttpSession httpSession = request.getSession();

        if (index != null)
            return "redirect: edition";
        if (isNull(httpSession.getAttribute("role")))
            return "/WEB-INF/views/main.jsp";
        if (httpSession.getAttribute("role").equals(Role.ADMIN))
            return "redirect: admin";
        else if (httpSession.getAttribute("role").equals(Role.READER))
            return "redirect: reader";
        return "/WEB-INF/views/main.jsp";
    }
}
