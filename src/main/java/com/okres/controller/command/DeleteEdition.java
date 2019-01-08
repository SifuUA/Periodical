package com.okres.controller.command;

import com.okres.controller.utils.ServletUtility;
import com.okres.model.service.EditionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteEdition implements Command {
    private ServletUtility servletUtility = new ServletUtility();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EditionService editionService = new EditionService();
        int id = Integer.parseInt(request.getParameter("iId"));
        System.out.println(id);
        editionService.deleteEditionById(id);
        request.getServletContext().setAttribute("editionList", editionService.getAllEditions());
        request.getServletContext().setAttribute("encodeImages", servletUtility.setEditionImage(request.getServletContext()));
        return "redirect: admin";
    }
}
