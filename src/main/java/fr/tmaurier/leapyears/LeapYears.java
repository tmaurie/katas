package fr.tmaurier.leapyears;

public class LeapYears {
    public boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && !(year % 100 == 0));
    }
}
