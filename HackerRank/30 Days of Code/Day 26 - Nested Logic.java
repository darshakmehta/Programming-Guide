import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        int actualDay, actualMonth, actualYear;
        int expectedDay, expectedMonth, expectedYear;
        
        Scanner sc = new Scanner(System.in);
        actualDay = sc.nextInt();
        actualMonth = sc.nextInt();
        actualYear = sc.nextInt();
        expectedDay = sc.nextInt();
        expectedMonth = sc.nextInt();
        expectedYear = sc.nextInt();
        
        GregorianCalendar gc = (GregorianCalendar) GregorianCalendar.getInstance();
        gc.set(actualYear, actualMonth - 1, actualDay);
        GregorianCalendar gc2 = (GregorianCalendar) GregorianCalendar.getInstance();
        gc2.set(expectedYear, expectedMonth - 1, expectedDay);
        Date d1 = gc.getTime();
        Date d2 = gc2.getTime();
        long actual = gc.getTimeInMillis();
        long expected = gc2.getTimeInMillis();
        if(actual <= expected) {
            System.out.println("0");
        } else if(actualMonth == expectedMonth && actualYear == expectedYear) {
            System.out.println(15 * (actualDay - expectedDay));
        } else if(actualYear == expectedYear) {
            System.out.println(500 * (actualMonth - expectedMonth));
        } else {
            System.out.println("10000");
        }
        
        
    }
}