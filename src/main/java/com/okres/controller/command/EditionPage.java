package com.okres.controller.command;

import com.okres.model.entity.Edition;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EditionPage implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<Edition, String> map = (HashMap<Edition, String>) request.getServletContext().getAttribute("encodeImages");
        findIamge(map, (String) request.getSession().getAttribute("editionIndex"), request);
        request.getSession().setAttribute("editionIndex", null);

        return "/WEB-INF/views/edition.jsp";
    }

    private void findIamge(Map<Edition, String> map, String index, HttpServletRequest request) {
        int position = Integer.parseInt(index);
        Map<Edition, String> currentEdition = new HashMap<>();

        for (Map.Entry<Edition, String> edition : map.entrySet()) {
            if (edition.getKey().getId() == position) {
                currentEdition.put(edition.getKey(), edition.getValue());
                request.getSession().setAttribute("oneEdition", currentEdition);
            }
        }
    }

}
