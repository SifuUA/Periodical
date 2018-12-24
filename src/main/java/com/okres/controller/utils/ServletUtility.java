package com.okres.controller.utils;

import com.okres.model.entity.Edition;
import com.okres.model.entity.enums.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.*;

public class ServletUtility {

    public void setEditionImage(HttpServletRequest request, HttpServletResponse response) {
        List<Edition> editionList = (List<Edition>) request.getServletContext().getAttribute("editionList");
        List<String> encodeImages = new ArrayList<>();

        for (Edition edition : editionList) {
            try {

                byte[] imageBytes = edition.getImage().getBytes(1, (int) edition.getImage().length());
                String encode = Base64.getEncoder().encodeToString(imageBytes);
                encodeImages.add(encode);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //request.setAttribute("encodeImages", encodeImages);
        request.getSession().setAttribute("encodeImages", encodeImages);
    }
}
