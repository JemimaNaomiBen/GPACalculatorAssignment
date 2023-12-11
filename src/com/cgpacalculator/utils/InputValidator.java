package com.cgpacalculator.utils;

public class InputValidator {
    public static boolean isValidCourseScore(int courseScore) {
        return courseScore >= 0 && courseScore <= 100;
    }

     public static boolean isValidCourseUnit(int courseUnit) {
        return courseUnit >= 0 && courseUnit <= 6;
    }

    public static boolean isValidCourseCode(String courseCode) {
        String regex = "^[\\p{L}0-9.#]+\\s\\d{3}$";
        return courseCode != null && !courseCode.trim().isEmpty() && courseCode.matches(regex);
    }

    public static boolean isValidInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
