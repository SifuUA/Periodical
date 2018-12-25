package com.okres.controller.command;

import com.okres.model.entity.Reader;
import com.okres.model.service.ReaderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ViewReaders implements Command {

    private ReaderService readerService = new ReaderService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Reader> readerList = readerService.getAllreaders();
        request.getSession().setAttribute("readerList", readerList);
        return "/WEB-INF/views/viewReaders.jsp";
    }
}
