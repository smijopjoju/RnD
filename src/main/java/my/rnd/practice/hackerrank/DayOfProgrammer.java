package my.rnd.practice.hackerrank;

import java.util.HashMap;
import java.util.Map;

public class DayOfProgrammer {

    private static final String YEAR = "YEAR";
    private static final String MONTH = "MONTH";
    private static final String DAY = "DAY";

    public static void main(String ...args) {
        System.out.println(dayOfProgrammer(1918));
    }

    static String dayOfProgrammer(int year) {
        StringBuilder dayOfProgrammer = null;
        boolean isLeapYear = isLeapYear(year);
        Map<String,Integer> programmerDayInGregorianCalender = findProgrammerDayInGregorianCalender(year,isLeapYear);
        if(year == 1918) {
            dayOfProgrammer = findProgrammerDayInJulianCalender(programmerDayInGregorianCalender);
        } else {
            dayOfProgrammer = new StringBuilder();

            if(String.valueOf(programmerDayInGregorianCalender.get(DAY)).length()>1) {
                dayOfProgrammer.append(programmerDayInGregorianCalender.get(DAY));
            } else {
                dayOfProgrammer.append("0")
                        .append(programmerDayInGregorianCalender.get(DAY));
            }
            dayOfProgrammer.append(".");
            if(String.valueOf(programmerDayInGregorianCalender.get(MONTH)).length() >1) {
                dayOfProgrammer.append(programmerDayInGregorianCalender.get(MONTH));
            } else {
                dayOfProgrammer.append("0")
                        .append(programmerDayInGregorianCalender.get(MONTH));
            }
            dayOfProgrammer.append(".")
                    .append(programmerDayInGregorianCalender.get(YEAR));
        }
        return dayOfProgrammer.toString();
    }

    static boolean isLeapYear(int year) {
        boolean isLeap = false;
        if(year < 1918) {
            isLeap = year % 4 == 0;
        } else {
            isLeap = (year % 4 == 0 && !(year % 100 == 0)) || (year % 400 == 0);
        }

        return isLeap;
    }

    static Map<String,Integer> findProgrammerDayInGregorianCalender(int year, boolean isLeapYear) {
        Map<String,Integer> programmerDay = new HashMap<>();
        int programmerDayCountInAYear = 256;
        int totalDaysInFeb = isLeapYear ? 29: 28;
        int totalDaysInAug = 31;
        int augMonthCount = 8;
        int totalDaysInEvenMonths = 30;
        int totalDaysInOddMonths = 31;
        int month = 1;
        int totalDays = 0;
        int day = 0;

        for(int months = 1; months <= 12; ++months) {
            day = programmerDayCountInAYear - totalDays;
            if(day > totalDaysInEvenMonths) {
                if(months == augMonthCount) {
                    totalDays+= totalDaysInAug;
                } else if(months%2 == 0 && months != 2) {
                    totalDays+= totalDaysInEvenMonths;
                } else if(months != 2) {
                    totalDays+= totalDaysInOddMonths;
                } else {
                    totalDays+= totalDaysInFeb;
                }
                ++month;
            } else {
                break;
            }
        }

        programmerDay.put(YEAR,year);
        programmerDay.put(MONTH,month);
        programmerDay.put(DAY,day);

        return programmerDay;
    }

    static StringBuilder findProgrammerDayInJulianCalender(Map<String,Integer> programmerDayInGregorianCalender) {
        StringBuilder programmerDay = new StringBuilder();
        int day = programmerDayInGregorianCalender.get(DAY);
        int month = programmerDayInGregorianCalender.get(MONTH);
        int year = programmerDayInGregorianCalender.get(YEAR);
        int dayInJuliaCalender = day + 13;


        if(String.valueOf(dayInJuliaCalender).length()>1) {
            programmerDay.append(dayInJuliaCalender);
        } else {
            programmerDay.append("0")
                    .append(dayInJuliaCalender);
        }
        programmerDay.append(".");
        if(String.valueOf(month).length() >1) {
            programmerDay.append(month);
        } else {
            programmerDay.append("0")
                    .append(month);
        }
        programmerDay.append(".")
                .append(year);
        return programmerDay;
    }
}
