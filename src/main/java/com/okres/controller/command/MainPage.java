package com.okres.controller.command;

import com.okres.controller.utils.ServletUtility;
import com.okres.model.entity.Edition;
import com.okres.model.entity.enums.Role;
import com.okres.model.service.EditionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;

public class MainPage implements Command {

    private EditionService editionService = new EditionService();
    private int rows = editionService.getNoOfRecords();
    private ServletUtility servletUtility = new ServletUtility();


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;
        int recordsPerPage = 12;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        int noOfPages = (int) Math.ceil(rows * 1.0 / recordsPerPage);
        Map<Edition, String> limitEditionImage =
                servletUtility.getLimitEditionImage(request, (page - 1) * recordsPerPage, recordsPerPage);
        request.getSession().setAttribute("encodeImages", limitEditionImage);
        request.getSession().setAttribute("numberOfPages", noOfPages);
        request.getSession().setAttribute("currentPage", page);

        String index = (String) request.getSession().getAttribute("editionIndex");
        return getPath(request, index);
    }

    private String getPath(HttpServletRequest request, String index) {
        HttpSession httpSession = request.getSession();

        if (index != null) {
            System.out.println(index);
            return "redirect: edition";
        }
        if (isNull(httpSession.getAttribute("role")))
            return "/WEB-INF/views/main.jsp";

        if (httpSession.getAttribute("role").equals(Role.ADMIN))
            return "redirect: admin";
        else if (httpSession.getAttribute("role").equals(Role.READER))
            return "redirect: reader";
        return "/WEB-INF/views/main.jsp";
    }
}
