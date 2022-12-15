package com.example.demorollback.utils;

public abstract class StringUtils {

    public static String limit(String value, int length) {
        StringBuilder buf = new StringBuilder(value);

        if (buf.length() > length) {
            buf.setLength(length);
            buf.append("...");
        }

        return buf.toString();
    }

}
