package com.example.movie_app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static boolean isUsernameValid(String credentials) {
        final String CREDENTIALS_PATTERN = "^[a-zA-Z]{3,20}$";

        Pattern pattern = Pattern.compile(CREDENTIALS_PATTERN);

        Matcher matcher = pattern.matcher(credentials);

        return matcher.matches();
    }

    public static boolean isEmailValid(String credentials) {
        final String CREDENTIALS_PATTERN = "^[a-zA-Z0-9.!@_-]{10,50}$";

        Pattern pattern = Pattern.compile(CREDENTIALS_PATTERN);

        Matcher matcher = pattern.matcher(credentials);

        return matcher.matches();
    }

    public static boolean isPasswordValid(String credentials) {
        final String CREDENTIALS_PATTERN = "^[a-zA-Z0-9.!@_]{5,20}$";

        Pattern pattern = Pattern.compile(CREDENTIALS_PATTERN);

        Matcher matcher = pattern.matcher(credentials);

        return matcher.matches();
    }
}
