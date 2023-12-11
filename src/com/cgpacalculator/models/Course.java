package com.cgpacalculator.models;

public class Course {
    private String courseCode;
    private int units;
    private double score;

    public Course(String courseCode, int units, double score) {
        this.courseCode = courseCode;
        this.units = units;
        this.score = score;
    }

    public int getUnits() {
        return units;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public double getScore() {
        return score;
    }
}
