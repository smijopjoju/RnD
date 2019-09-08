package my.rnd.practice.bookings;

import java.util.*;
import java.util.stream.Collectors;

public class MissingReservation {

    public static void main(String ...args) {
        List<List<Integer>> firstReservationList = new ArrayList<>();
        List<Integer> data1 = Arrays.asList(1234,532632);
        List<Integer> data2 = Arrays.asList(2354,732634);
        firstReservationList.add(data1);
        firstReservationList.add(data2);

        List<List<Integer>> secondReservationList = new ArrayList<>();
        List<Integer> data11 = Arrays.asList(1234,532632);
        List<Integer> data22 = Arrays.asList(2354,732634);
        List<Integer> data33 = Arrays.asList(234,632633);
        List<Integer> data44 = Arrays.asList(458,642633);
        secondReservationList.add(data11);
        secondReservationList.add(data22);
        secondReservationList.add(data33);
        secondReservationList.add(data44);
        List<Integer> missingReservation = missingReservations(firstReservationList,secondReservationList);
        for(Integer num: missingReservation) {
            System.out.println(num);
        }
    }

    public static List<Integer> missingReservations(List<List<Integer>> firstReservationList, List<List<Integer>> secondReservationList) {
        // Write your code here
        List<List<Integer>> missingReservationIds = new ArrayList<>();
        if( firstReservationList != null && !firstReservationList.isEmpty() && secondReservationList != null) {
            missingReservationIds = secondReservationList.stream().filter(list1Val->{
                return firstReservationList.stream().filter(list2Val ->{
                    return list1Val.get(0).equals(list2Val.get(0));
                }).count() <1;
            }).collect(Collectors.toList());

        } else if(secondReservationList != null && !secondReservationList.isEmpty()){
            missingReservationIds = secondReservationList;
        }

        Collections.sort(missingReservationIds, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> integers, List<Integer> t1) {
                if( !integers.isEmpty() && integers.size()==2 &&
                        !t1.isEmpty() && t1.size()==2)
                return integers.get(1).compareTo(t1.get(1));

                return -1;
            }
        });

        List<Integer> missingReservations = missingReservationIds.stream().map(reservations->reservations.get(0))
                .collect(Collectors.toList());

        return missingReservations;
    }
}
