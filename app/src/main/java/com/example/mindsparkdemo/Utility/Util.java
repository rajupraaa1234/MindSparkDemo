package com.example.mindsparkdemo.Utility;

public class Util {

//   public static int removeColon(String s) {
//        if (s.length() == 4)
//            s = s.substring(0,1) + s.substring(2);
//
//        if (s.length() == 5)
//            s = s.substring(0,2) + s.substring(3);
//
//        return Integer.valueOf(s);
//    }
//
//   public static String diff(String s1, String s2) {
//        int time1 = removeColon(s1);
//        int time2 = removeColon(s2);
//
//        int hourDiff = time2 / 100 - time1 / 100 - 1;
//
//        int minDiff = time2 % 100 + (60 - time1 % 100);
//
//        if (minDiff >= 60) {
//            hourDiff++;
//            minDiff = minDiff - 60;
//        }
//        String res = String.valueOf(hourDiff) + ':' + String.valueOf(minDiff);
//        return res;
//    }



    static int getTimeInSeconds(String str) {
        String[] curr_time = str.split(":");
        int t = Integer.parseInt(curr_time[0]) * 60 * 60 + Integer.parseInt(curr_time[1]) * 60
                + Integer.parseInt(curr_time[2]);

        return t;
    }

    static String convertSecToTime(int t) {
        int hours = t / 3600;
        String hh = hours < 10 ? "0" + Integer.toString(hours)
                : Integer.toString(hours);
        int min = (t % 3600) / 60;
        String mm = min < 10 ? "0" + Integer.toString(min)
                : Integer.toString(min);
        int sec = ((t % 3600) % 60);
        String ss = sec < 10 ? "0" + Integer.toString(sec)
                : Integer.toString(sec);
        String ans = hh + ":" + mm + ":" + ss;
        return ans;
    }

   public static String diff(String st, String et) {

        int t1 = getTimeInSeconds(st);
        int t2 = getTimeInSeconds(et);

        int time_diff = (t1 - t2 < 0) ? t2 - t1 : t1 - t2;

        return convertSecToTime(time_diff);
    }
}
