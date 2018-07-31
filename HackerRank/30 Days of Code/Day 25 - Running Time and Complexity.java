import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0) {
            int n = sc.nextInt();
            if(n == 1)
                System.out.println("Not prime");
            else {
                boolean flag = false;
                for(int i = 2; i <= Math.sqrt(n); i++) {
                    if(n % i == 0) {
                        flag = true;
                        break;
                    }
                }
                if(flag) {
                    System.out.println("Not prime");
                } else {
                    System.out.println("Prime");
                }
            }
        }
    }
}