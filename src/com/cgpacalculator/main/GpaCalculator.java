package com.cgpacalculator.main;

import com.cgpacalculator.models.Course;
import com.cgpacalculator.services.GpaCalculationService;
import com.cgpacalculator.utils.Console;

public class GpaCalculator {

    public static void main(String[] args) {
        System.out.println("Welcome to GPA Calculator");

        int numberOfCourses = Console.retrievePositiveNumber("Enter the number of Courses you want to grade: ");
        Course[] courses = new Course[numberOfCourses];


        for (int i = 0; i < numberOfCourses; i++) {
            Course course = captureCourseInput(i);
            // This adds the course to the array
            courses[i] = course;
        }

        printCourseInfo(courses);

        double gpa = GpaCalculationService.calculateGPA(courses);
        System.out.printf("\nYour GPA is: %.2f to 2 decimal places\n", gpa);
    }

    private static void printCourseInfo(Course[] courses) {
        System.out.println("\nCourse details and grades:\n");

        System.out.println("|----------------------------|-----------------------|------------|---------------------|");
        System.out.println("| COURSE & CODE              | COURSE UNIT           | GRADE      | GRADE-UNIT          |");
        System.out.println("|----------------------------|-----------------------|------------|---------------------|");

        for (Course course : courses) {
            String grade = GpaCalculationService.convertToLetterGrade(course.getScore());
            int gradePoint = GpaCalculationService.convertToNumericGrade(course.getScore());

            System.out.format("| %-27s| %-21s | %-10s | %-19s |\n",
                    course.getCourseCode(), course.getUnits(), grade, gradePoint);
        }
        System.out.println("|---------------------------------------------------------------------------------------|");
    }

    private static Course captureCourseInput(int index) {
        int count = index + 1;
        System.out.println("\nEnter details for Course #" + count);

        String courseCode = Console.retrieveCourseCode("Course Code: ");
        int units = Console.retrieveCourseUnit("Units: ");
        double score = Console.retrieveCourseScore("Score: ");

        return new Course(courseCode, units, score);
    }
}