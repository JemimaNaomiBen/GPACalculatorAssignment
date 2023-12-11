package com.cgpacalculator.utils;

import java.util.Scanner;

public class Console {
    private static final Scanner scanner = new Scanner(System.in);

    public static int retrievePositiveNumber(String prompt) {
        int value;

        while (true) {
            System.out.print(prompt);
            String inputValue = scanner.nextLine();

            if (!InputValidator.isValidInteger(inputValue)) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }

            value = Integer.parseInt(inputValue);

            if (value > 12) {
                System.out.println("Maximum number of courses is 12");
                continue;
            }
            if (value > 0) break;
        }
        return value;
    }

    public static String retrieveCourseCode(String prompt) {
        String courseCode;

        while (true) {
            System.out.print(prompt);
            courseCode = scanner.nextLine();

            if (InputValidator.isValidCourseCode(courseCode)) {
                break;
            }

            System.out.println("Invalid course code. Please enter a valid course that ends with 3 digits(e.g 101).");
        }
        return courseCode;
    }

    public static int retrieveCourseScore(String prompt) {
        int courseScore;

        while (true) {
            System.out.print(prompt);
            String inputValue = scanner.nextLine();

            if (!InputValidator.isValidInteger(inputValue)) {
                System.out.println("Invalid input. Please enter a valid course score.");
                continue;
            }

            courseScore = Integer.parseInt(inputValue);
            
            if (!InputValidator.isValidCourseScore(courseScore)) {
                System.out.printf("Course Score Should be between %d and %d\n", 0, 100);
                continue;
            }
            
            break;
        }
        
        return courseScore;
    }

    public static int retrieveCourseUnit(String prompt) {
        int courseUnit;

        while (true) {
            System.out.print(prompt);
            String inputValue = scanner.nextLine();

            if (!InputValidator.isValidInteger(inputValue)) {
                System.out.println("Invalid input, Please enter a valid course unit.");
                continue;
            }

            courseUnit = Integer.parseInt(inputValue);

            if (!InputValidator.isValidCourseUnit(courseUnit)) {
                System.out.println("Invalid Course Unit, Please enter a valid course unit between 0 and 6.");
                continue;
            }

            break;
        }

        return courseUnit;
    }
}

