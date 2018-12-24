package com.okres.controller.command;

import com.okres.model.service.EditionService;
import com.okres.model.service.ReaderService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class Upload implements Command {

    private String editionName;
    private int category;
    private int price;
    private FileItem file = null;
    private EditionService editionService = new EditionService();

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
                    } else {
                        file = fileItem;
                    }
                }
                editionService.inputEditionData(editionName, category, price, file);
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        return "/WEB-INF/views/admin.jsp";
    }

    private void processFormField(FileItem item) {
        if (item.getFieldName().equals("editionName")) {
            this.editionName = item.getString();
        } else if (item.getFieldName().equals("category")) {
            category = Integer.parseInt(item.getString());
        } else if (item.getFieldName().equals("price")) {
            price = Integer.parseInt(item.getString());
        }
    }

}


    /*private final String UPLOAD_DIRECTORY = "/home/alex/Pictures/uploads";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        String name = new File(item.getName()).getName();
                        item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
                    }
                }
                request.setAttribute("message", "File upload successfully");
            } catch (java.lang.Exception e) {
                request.setAttribute("message", "File Upload Failed due to " + e);
            }
        } else {
            request.setAttribute("message",
                    "Sorry this Servlet only handles file upload request");
        }
        return "/WEB-INF/views/admin.jsp";
    }*/
//}
