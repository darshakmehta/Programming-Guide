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
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        int temp = n;
        Stack<Integer> stack = new Stack<Integer>();
        while(n != 0) {
            stack.push(n%2);
            n = n/2;
        }
        int a[] = new int[stack.size()];
        int i = 0;
        
        while(!stack.isEmpty()) {
            a[i++] = stack.pop();
        }
        int count = 0;
        int result = 0;
        /* O(n) time to find consecutive one's */
        for(i = 0; i < a.length; i++) {
            if(a[i] == 0)
                count = 0;
            else{
                count++;
                result = Math.max(result, count);
            }
        }
        
        System.out.println(result);
        scanner.close();
    
    }
}
