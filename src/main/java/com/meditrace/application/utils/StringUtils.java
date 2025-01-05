package com.meditrace.application.utils;

public class StringUtils {

    public static String getValue(String value) {
        if (value == null || value.isEmpty())
            return null;

        return value.trim();
    }

    public static String getEmptyValue(String value) {
        if (value == null || value.isEmpty())
            return "";

        return value.trim();
    }

    public static String getLowerCaseValue(String value) {
        if (value == null || value.isEmpty())
            return null;

        return value.trim().toLowerCase();
    }

    public static String getUpperCaseValue(String value) {
        if (value == null || value.isEmpty())
            return null;

        return value.trim().toUpperCase();
    }

    public static String capitalize(String value) {
        if (value == null || value.isEmpty())
            return null;

        return value.substring(0, 1).toUpperCase() + value.substring(1).toLowerCase();
    }

    public static String getEmpty(String value) {
        if (value == null || value.isEmpty())
            return "";

        return value;
    }

    public static boolean isValidIdNumber(String idNumber) {
        // Regular expression: two letters followed by 6 digits/letters
        String regex = "^[A-Za-z]{2}\\w{6}$";
        return idNumber.matches(regex);
    }

    public static boolean isValidNumber(String input) {
        // Regular expression to match numbers with an optional single point
        String regex = "^[0-9]+(\\.[0-9]+)?$";
        return input.matches(regex);
    }

    public static boolean isNumeric(String input) {
        // Regular expression to match only digits
        String regex = "^[0-9]+$";
        return input.matches(regex);
    }
}