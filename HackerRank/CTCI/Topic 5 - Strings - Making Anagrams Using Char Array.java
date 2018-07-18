import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {
    public static int numberNeeded(String first, String second) {
        int a[] = new int [27];
        int b[] = new int [27];
        int ans = 0;
      
        for(int i = 0; i < first.length(); i++){
            int value = (int) first.charAt(i);
            a[value - 96]++;
        }
        for(int i = 0; i < second.length(); i++){
            int value = (int) second.charAt(i);
            b[value - 96]++;
        }
        /*for(int i = 1; i<a.length; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
        for(int i = 1; i<b.length; i++){
            System.out.print(b[i]+" ");
        }*/
        for(int i = 1; i<a.length; i++){
            ans += (Math.abs(a[i] - b[i]));
        }
        
        return ans;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
