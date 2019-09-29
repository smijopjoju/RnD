package my.rnd.practice.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoundStudentGrade {

    public static void main(String ...args) {
        List<Integer> grades = gradingStudents(Arrays.asList(73,67,38,33));
        try {
            for (Integer grade : grades) {
                System.out.println(grade);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        List<Integer> roundedGrades = new ArrayList<>();
        Integer value = 0;
        Integer updatedValue = 0;
        int count = 0;
        for(int index = 0; index < grades.size(); ++index) {
            value = grades.get(index);
            updatedValue = value;
            count = 0;
            if(value>=38) {
                while(count<=2) {
                    if(updatedValue%5 == 0) {
                        value = updatedValue;
                        break;
                    }
                    ++updatedValue;
                    ++count;
                }
            }
            roundedGrades.add(value);
        }
        return roundedGrades;
    }
}
