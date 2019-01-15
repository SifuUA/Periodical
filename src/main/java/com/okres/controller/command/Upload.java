package com.okres.controller.command;

import com.okres.controller.utils.ServletUtility;
import com.okres.model.entity.Edition;
import com.okres.model.service.EditionService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */

@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class Upload implements Command {
    private static final Logger logger = Logger.getLogger(Upload.class);
    private FileItem file = null;
    private EditionService editionService = new EditionService();
    private Edition edition = new Edition();

    /**
     * Method for upload image to DB (insert new Edition)
     *
     * @return main admin page
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ServletUtility servletUtility = new ServletUtility();
        response.setContentType("text/html;charset=UTF-8");
        try {
            boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
            if (isMultiPart) {
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                List items = upload.parseRequest(request);
                for (FileItem fileItem : (Iterable<FileItem>) items) {
                    if (fileItem.isFormField())
                        processFormField(fileItem);
                    else
                        file = fileItem;
                }
                editionService.inputEditionData(edition, file);
            }
        } catch (FileUploadException e) {
            logger.error("Error when try to upload image to DB: " + e);
        }
        request.getServletContext().setAttribute("editionList", editionService.getAllEditions());
        request.getServletContext().setAttribute("encodeImages", servletUtility.setEditionImage(request.getServletContext()));
        return "/WEB-INF/views/admin.jsp";
    }

    private void processFormField(FileItem item) {
        if (item.getFieldName().equals("editionName")) {
            edition.setEditionName(item.getString());
        } else if (item.getFieldName().equals("category")) {
            edition.setCategory(Integer.parseInt(item.getString()));
        } else if (item.getFieldName().equals("price")) {
            edition.setPrice(Integer.parseInt(item.getString()));
        } else if (item.getFieldName().equals("notation"))
            edition.setNotation(item.getString());
    }
}
