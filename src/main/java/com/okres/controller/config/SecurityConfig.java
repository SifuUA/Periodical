package com.okres.controller.config;

import com.okres.model.entity.enums.Role;

import java.util.*;

public class SecurityConfig {

    private static final Map<Role, List<String>> mapConfig = new HashMap<>();

    private static void init() {
        List<String> readerUrlPatterns = new ArrayList<>();
        readerUrlPatterns.add("/subscriptions");
        readerUrlPatterns.add("/registerPayment");
        readerUrlPatterns.add("/registerPayment");
        mapConfig.put(Role.READER, readerUrlPatterns);

        List<String> adminUrlPatterns = new ArrayList<>();
        adminUrlPatterns.add("/addEdition");
        adminUrlPatterns.add("/viewRegisterReaders");
        mapConfig.put(Role.ADMIN, adminUrlPatterns);
    }

    public static Set<Role> getAllAppRoles() {
        return mapConfig.keySet();
    }

    public static List<String> getAllUrlForRole(Role r) {
        return mapConfig.get(r);
    }
}
