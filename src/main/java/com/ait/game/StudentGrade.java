package com.ait.game;

public class StudentGrade {

    public static char getGrade(int mark) {
        if (mark >= 85) {
            return 'A';
        } else if (mark >= 70 && mark < 85) {
            return 'B';
        } else if (mark >= 55 && mark < 70) {
            return 'C';
        } else if (mark >= 40 && mark < 55) {
            return 'D';
        } else if (mark >= 25 && mark < 40) {
            return 'E';
        } else {
            return 'F';
        }
    }
}
