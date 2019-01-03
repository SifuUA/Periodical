package com.okres.controller.command;

import com.okres.model.service.EditionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteEdition implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EditionService editionService = new EditionService();
        int id = Integer.parseInt(request.getParameter("iId"));
        System.out.println(id);
        editionService.deleteEditionById(id);
        return "redirect: admin";
    }
}
