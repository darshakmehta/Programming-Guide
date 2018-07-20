//With Calendar and Date class
import java.util.Calendar;
import java.util.Date;
public class Solution{
    
    public static String getDay(String d, String m, String y) {
        Calendar c = Calendar.getInstance();
        c.set(Integer.parseInt(y), Integer.parseInt(m) - 1, Integer.parseInt(d));
        Date d1 = c.getTime();
        
        String days[] = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
        return days[d1.getDay()];
    }

/*

    //Without Calendar Class

import java.util.Calendar;
import java.util.Date;
public class Solution{
    
public static String getDay(String d, String m, String y) {
    Date date = new Date(Integer.parseInt(y), Integer.parseInt(m) - 1, Integer.parseInt(d));
    String days[] = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
    return days[date.getDay() - 1];
}

Fails for few test cases, as well as TLE

*/