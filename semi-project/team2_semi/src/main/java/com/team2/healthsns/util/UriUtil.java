package com.team2.healthsns.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class UriUtil {

    public static String makeSearch(int page, String searchType, String keyword, String category,
                                    String postSort) {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .queryParam("page", page)
                .queryParam("searchType", searchType)
                .queryParam("keyword", encoding(keyword))
                .queryParam("category", category)
                .queryParam("postSort", postSort)
                .build();

        return uriComponents.toUriString();
    }

    private static String encoding(String value) {
        if (value == null || value.trim().length() == 0) {
            return "";
        }

        try {
            return URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Encoding not supported", e);
        }
    }

}