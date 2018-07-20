import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String s = sc.nextLine();
        while(t > 0) {
            s = sc.nextLine();
            char c[] = s.toCharArray();
            
            for(int i = 0; i <c.length; i+=2)
                System.out.print(c[i]);
            System.out.print(" ");
            for(int i = 1; i <c.length; i+=2)
                System.out.print(c[i]);
            System.out.println();
            t--;
        }    
    }
}