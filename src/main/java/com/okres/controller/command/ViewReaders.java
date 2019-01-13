package com.okres.controller.command;

import com.okres.model.entity.Reader;
import com.okres.model.service.ReaderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */

public class ViewReaders implements Command {
    private ReaderService readerService = new ReaderService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Reader> readerList = readerService.getAllreaders();
        request.getSession().setAttribute("readerList", readerList);
        return "/WEB-INF/views/viewReaders.jsp";
    }
}
