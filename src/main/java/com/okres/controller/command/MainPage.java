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

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletUtility servletUtility = new ServletUtility();

        int page = 1;
        int recordsPerPage = 5;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        int noOfPages = (int) Math.ceil(rows * 1.0 / recordsPerPage);
        List<Edition> editionResultList = servletUtility.viewAllEditions((page - 1) * recordsPerPage,
                recordsPerPage, request);
        Map<Edition, String> limitEditionImage = servletUtility.getLimitEditionImage(request, (page - 1) * recordsPerPage, recordsPerPage);

        request.setAttribute("editionResultList", editionResultList);
        //request.setAttribute("encodeImages", servletUtility.setEditionImage(editionList));
        request.setAttribute("encodeImages", limitEditionImage);
        request.setAttribute("numberOfPages", noOfPages);
        request.setAttribute("currentPage", page);


        HttpSession httpSession = request.getSession();
        String index = (String) request.getSession().getAttribute("editionIndex");
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
