package com.okres.controller.utils;

import com.okres.model.entity.Reader;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class AppUtils {

    private static int REDIRECT_ID = 0;

    private static final Map<Integer, String> idUriMap = new HashMap<>();
    private static final Map<String, Integer> uriIdMap = new HashMap<>();

    public static void storeLogginedReader(HttpSession session, Reader reader) {
        session.setAttribute("loginedReader", reader);
    }

    public static Reader getLoginedReader(HttpSession session) {
        return (Reader) session.getAttribute("loginedReader");
    }

    public static int storeRedirectAfterLoginUrl(HttpSession session, String requestUri) {
        Integer id = uriIdMap.get(requestUri);

        if (id == null) {
            id = REDIRECT_ID++;

            uriIdMap.put(requestUri, id);
            idUriMap.put(id, requestUri);
            return id;
        }

        return id;
    }

    public static String getRedirectAfterLoginUrl(HttpSession session, int redirectId) {
        String url = idUriMap.get(redirectId);
        if (url != null) {
            return url;
        }
        return null;
    }
}
