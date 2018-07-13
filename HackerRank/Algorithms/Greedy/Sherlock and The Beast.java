import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");       
            StringBuilder result = new StringBuilder("");
            int number = n;
            while(number % 3 != 0) {
                number -= 5;
            }
            if(number <0 || n <3) {
                System.out.println("-1");
                continue;
            }
            for(int i = 0; i < number; i++)
                result.append("5");
            for(int i = number; i < n; i++)
                result.append("3");
            
            System.out.println(result.toString());
        }
        
        scanner.close();
    }
}
