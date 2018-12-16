package com.okres.controller.utils;

import com.okres.controller.Servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Map;

public class UrlPatternUtils {

    private static boolean hasUrlPattern(ServletContext servletContext, String urlPattern) {
        Map<String , ? extends ServletRegistration> map = servletContext.getServletRegistrations();

        for (String servletName : map.keySet()) {
            ServletRegistration sr = map.get(servletName);
            Collection<String> mappings = sr.getMappings();
            if (mappings.contains(urlPattern)) {
                return true;
            }
        }
        return false;
    }

    public static String getUrlPattern(HttpServletRequest request) {
        ServletContext servletContext = request.getServletContext();
        String servletPath = request.getServletPath();
        String pathInfo = request.getPathInfo();
        String urlPattern = null;

        if (pathInfo != null) {
            urlPattern = servletPath + "/";
            return urlPattern;
        }
        urlPattern = servletPath;

        boolean hasUrlPattern = hasUrlPattern(servletContext, urlPattern);
        if (hasUrlPattern)
            return urlPattern;

        int index = servletPath.lastIndexOf('.');
        if (index != -1) {
            String path = servletPath.substring(index + 1);
            urlPattern = "*." + path;
            hasUrlPattern = hasUrlPattern(servletContext, urlPattern);

            if (hasUrlPattern)
                return urlPattern;
        }
        return "/";
    }
}
