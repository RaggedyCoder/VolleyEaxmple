package com.betelgeuse.example.util;

public final class API {

    private static final String VERSION = "v2";
    public static final String NEWS_FEED_LIST = URL.MAIN + DELIMITER.SLASH + VERSION
            + DELIMITER.SLASH + PATH_VARIABLE.NEWS_FEED;
    public static final String FRIEND_LIST = URL.MAIN + DELIMITER.SLASH + VERSION
            + DELIMITER.SLASH + PATH_VARIABLE.FRIENDS;

    private final class PATH_VARIABLE {
        static final String NEWS_FEED = "57d004cf260000a01e65005a";
        static final String FRIENDS = "57d00bcc260000f01e650070";
    }

    private final class URL {
        static final String MAIN = "http://www.mocky.io";
    }

    private final class DELIMITER {
        static final String SLASH = "/";
    }
}
