package my.rnd.practice.hackerrank;

public class TimeConversion {

    public static void main(String... args) {
        System.out.println(timeConversion("07:05:45PM"));
    }

    static String timeConversion(String s) {
        StringBuilder twentyFourHourFormatTime = new StringBuilder();
        if (s != null && s.trim().length() > 0) {
            String[] twelveHourTimes = s.split(":");
            if (twelveHourTimes.length >= 3) {
                if (twelveHourTimes[2].contains("AM")) {
                    if (Integer.valueOf(twelveHourTimes[0]) == 12) {
                        twentyFourHourFormatTime.append("00");
                    } else {
                        twentyFourHourFormatTime.append(twelveHourTimes[0]);
                    }
                    twentyFourHourFormatTime.append(":")
                            .append(twelveHourTimes[1])
                            .append(":")
                            .append(twelveHourTimes[2].substring(0, 2));
                } else {
                    if(Integer.valueOf(twelveHourTimes[0])<12) {

                        twentyFourHourFormatTime.append(Integer.valueOf(twelveHourTimes[0])+12);
                    } else {
                        twentyFourHourFormatTime.append(twelveHourTimes[0]);
                    }
                    twentyFourHourFormatTime.append(":")
                            .append(twelveHourTimes[1])
                            .append(":")
                            .append(twelveHourTimes[2].substring(0, 2));
                }
            }
        }

        return twentyFourHourFormatTime.toString();
    }
}
