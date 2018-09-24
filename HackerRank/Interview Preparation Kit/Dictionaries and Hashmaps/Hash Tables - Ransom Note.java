import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> hmap = new HashMap<String, Integer>();
        for(int i = 0; i < magazine.length; i++) {
            int count = 1;
            if(hmap.containsKey(magazine[i])) {
                count = hmap.get(magazine[i]);
                count++;
            } 
            hmap.put(magazine[i], count);
        }
        boolean flag = true;
        for(int i = 0; i < note.length; i++) {
            if(hmap.containsKey(note[i])) {
                int count = hmap.get(note[i]);
                if(count > 0)
                    hmap.put(note[i], --count);
                else {
                    flag = false;
                    break;
                }
            } else {
                flag = false;
                break;
            }
        }
        if(flag)
            System.out.println("Yes");
        else
            System.out.println("No");

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
