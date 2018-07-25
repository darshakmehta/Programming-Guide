import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
        /*
         * Write your code here.
         */
        int result = 0;
        int half =  (int) Math.floor(n / 2.0);
        System.out.println(result + " " + half);
        if(n % 2 != 0 && (p == n - 1 || p == n || p == 1)) {
            return 0;
        } else if(n % 2 == 0 && (p == n || p == 1)) {
            return 0;
        } else {
            int diff = n - p;
            if(n % 2 == 0) { 
                result = (int) Math.ceil(diff / 2.0);
                if(result > half / 2) {
                    result = half - result;
                }
            } else {
                result = (int) Math.floor(diff / 2.0);
                System.out.println(result);
                if(result > (half / 2)) {
                    result = half - result;
                }
            }
        } 
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

/***

Intuition: We know that, if we start from page 1; the result will always be p/2 page turns.
Now, since we can start turning from backwards as well;

Formula: 
If n is odd ==> (n - p) / 2
If n is even ==> (n - p + 1) / 2

***/
