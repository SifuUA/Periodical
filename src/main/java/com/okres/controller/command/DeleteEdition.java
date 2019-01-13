package com.okres.controller.command;

import com.okres.controller.utils.ServletUtility;
import com.okres.model.service.EditionService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */

public class DeleteEdition implements Command {
    private static Logger logger = Logger.getLogger(DeleteEdition.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ServletUtility servletUtility = new ServletUtility();
        EditionService editionService = new EditionService();
        int id = Integer.parseInt(request.getParameter("iId"));
        logger.debug("Was deleted edition on id: " + id);
        editionService.deleteEditionById(id);
        request.getServletContext().setAttribute("editionList", editionService.getAllEditions());
        request.getServletContext().setAttribute("encodeImages", servletUtility.setEditionImage(request.getServletContext()));
        return "redirect: admin";
    }
}
