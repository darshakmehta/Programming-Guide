import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        
        int gary = 0;
        int countValleys = 0;
        boolean flag = true;
        char ch[] = s.toCharArray();
        for(char c : ch) {
            if(c == 'U') {
                gary++;
            } else if(c == 'D') {
                gary--;
            }
            if(gary > 0) {
                flag = false;
            } else if(gary < 0) {
                flag = true;
            }
            if(gary == 0 && flag) {
                countValleys++;
            }
        }
        return countValleys;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
