package com.okres.controller.command;

import com.okres.model.entity.Edition;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */

public class EditionPage implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Map<Edition, String> map = (HashMap<Edition, String>) request.getServletContext().getAttribute("encodeImages");
        findImage(map, String.valueOf(request.getSession().getAttribute("imageIndex")), request);
        request.getSession().setAttribute("editionIndex", null);
        return "/WEB-INF/views/edition.jsp";
    }

    /**
     * Simple loop for given position of edition and then set to the request session for further actions.
     *
     * @param map   of all encode images from DB
     * @param index given index of edition
     */
    private void findImage(Map<Edition, String> map, String index, HttpServletRequest request) {
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
