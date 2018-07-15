import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        if(s.trim().length() == 0) {
            System.out.println("0");
            return;
        }
        // Write your code here.
        scan.close();
        s = s.trim();
        String []arr = s.split("\\s*[^a-zA-Z]+");
        System.out.println(arr.length);
        for(String s1: arr) {
                System.out.println(s1);
        }
    }
}

