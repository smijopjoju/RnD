package my.rnd.practice.bookings;

import java.util.*;

public class MinimumBreaks {

    public static void main(String ...args) {

    }

    public static List<List<Integer>> employeeWithLesserThanKBreaks(List<List<Integer>> employeeCalls, int k) {
        // Write your code here
        List<List<Integer>> breakDetails = new ArrayList<>();
        Map<Integer,List<List<Integer>>> employeesLog = new HashMap<>();
        for(List<Integer> log : employeeCalls) {
            if(employeesLog.containsKey(log.get(0))) {
                employeesLog.get(log.get(0)).add(log);
            } else {
                List list = new ArrayList();
                list.add(log);
                employeesLog.put(log.get(0), list);
            }
        }

        for(Map.Entry<Integer, List<List<Integer>>> eachEmployeeLog : employeesLog.entrySet()) {
            List<List<Integer>> log = eachEmployeeLog.getValue();
            int breakCount = 0;
            Integer lastCallTime = log.get(0).get(2);
            Integer currentLastCallTime = 0;
            for(List<Integer> logDetails: log) {
                currentLastCallTime = logDetails.get(2);
                if(lastCallTime != currentLastCallTime) {
                    ++breakCount;
                }
            }

            if(breakCount<k) {
                List<Integer> detailsList = new ArrayList<>();
                detailsList.add(eachEmployeeLog.getKey());
                detailsList.add(breakCount);
                breakDetails.add(detailsList);
            }
        }

        return breakDetails;
    }
}
