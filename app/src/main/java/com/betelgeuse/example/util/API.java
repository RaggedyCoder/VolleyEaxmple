package com.betelgeuse.example.util;

public final class API {

    private static final String VERSION = "v2";
    public static final String NEWS_FEED_LIST = URL.MAIN + DELIMITER.SLASH + VERSION
            + DELIMITER.SLASH + PATH_VARIABLE.NEWS_FEED;

    private final class PATH_VARIABLE {
        static final String NEWS_FEED = "57cee4db260000050464feee";
    }

    private final class URL {
        static final String MAIN = "http://www.mocky.io";
    }

    private final class DELIMITER {
        static final String SLASH = "/";
    }
}
