package com.okres.controller.utils;

import com.okres.controller.config.SecurityConfig;
import com.okres.model.entity.enums.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

public class SecurityUtils {

    /**
     * Check if current request needs login
     */
    public static boolean isSecurityPage(HttpServletRequest request) {
        String urlPattern = UrlPatternUtils.getUrlPattern(request);

        Set<Role> roles = SecurityConfig.getAllAppRoles();

        for (Role role : roles) {
            List<String> urlPatterns = SecurityConfig.getAllUrlForRole(role);
            if (urlPatterns != null && urlPatterns.contains(urlPattern)) {
                return true;
            }
        }
        return false;
    }

    // Проверить имеет ли данный 'request' подходящую роль?
    public static boolean hasPermission(HttpServletRequest request) {
        String urlPattern = UrlPatternUtils.getUrlPattern(request);

        Set<Role> allRoles = SecurityConfig.getAllAppRoles();

        for (Role role : allRoles) {
            if (!request.isUserInRole(String.valueOf(role))) {
                continue;
            }
            List<String> urlPatterns = SecurityConfig.getAllUrlForRole(role);
            if (urlPatterns != null && urlPatterns.contains(urlPattern)) {
                return true;
            }
        }
        return false;
    }

}
