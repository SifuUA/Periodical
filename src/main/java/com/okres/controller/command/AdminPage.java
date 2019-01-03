package com.okres.controller.command;

import com.okres.controller.utils.ServletUtility;
import com.okres.model.entity.Edition;
import com.okres.model.entity.enums.Role;
import com.okres.model.service.EditionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class AdminPage implements Command {

    private ServletUtility servletUtility = new ServletUtility();

    private EditionService editionService = new EditionService();
    private int rows = editionService.getNoOfRecords();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int page = 1;
        int recordsPerPage = 12;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        int noOfPages = (int) Math.ceil(rows * 1.0 / recordsPerPage);

        Map<Edition, String> limitEditionImage = servletUtility.getLimitEditionImage(request, (page - 1) * recordsPerPage, recordsPerPage);

        //request.setAttribute("editionResultList", editionResultList);
        //request.setAttribute("encodeImages", servletUtility.setEditionImage(editionList));
        request.getSession().setAttribute("encodeImages", limitEditionImage);
        request.getSession().setAttribute("numberOfPages", noOfPages);
        request.getSession().setAttribute("currentPage", page);

        String index = request.getParameter("editionIndex");
        if (index != null) {
            System.out.println(index);
            request.getSession().setAttribute("editionIndex", index);
            return "redirect: edition";
        }
        if (!request.getSession().getAttribute("role").equals(Role.ADMIN))
            return "/WEB-INF/views/main.jsp";
        return "/WEB-INF/views/admin.jsp";
    }
}
