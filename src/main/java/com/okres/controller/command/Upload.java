package com.okres.controller.command;

import com.okres.model.entity.Edition;
import com.okres.model.service.EditionService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class Upload implements Command {

    private FileItem file = null;
    private EditionService editionService = new EditionService();
    private Edition edition = new Edition();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try {
            long maxFileSize = (2 * 1024 * 1024);
            int maxMemSize = (2 * 1024 * 1024);
            boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
            if (isMultiPart) {
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                List items = upload.parseRequest(request);
                Iterator<FileItem> iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem fileItem = iter.next();
                    if (fileItem.isFormField()) {
                        processFormField(fileItem);
                    } else
                        file = fileItem;
                }
                editionService.inputEditionData(edition, file);
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
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
