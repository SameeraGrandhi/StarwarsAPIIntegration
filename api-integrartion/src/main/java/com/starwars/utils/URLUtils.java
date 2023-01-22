package com.starwars.utils;

import lombok.NonNull;

public class URLUtils {

    public static int getIdFromUrl(@NonNull final String url) {
        return url.charAt(url.length()-1)-'0';
    }
}
