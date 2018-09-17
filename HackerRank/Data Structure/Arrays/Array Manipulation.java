import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    // Source: https://www.geeksforgeeks.org/prefix-sum-array-implementation-applications-competitive-programming/
    static long arrayManipulation(int n, int[][] queries) {
        long a[] = new long[n + 1];
        
        for(int i = 0; i < queries.length; i++) {
            int lowerBound = queries[i][0];
            int upperBound = queries[i][1];
            
            a[lowerBound] += queries[i][2];
            if(upperBound != n)
                a[upperBound + 1] -= queries[i][2];
        }

        /*
Important lesson: Printing all the elements to the debug will timeout, so comment the SOPLN statement when not required, so save time.
With the following for loop, the code will TLE

        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        */

        long sum = 0;
        long result = Integer.MIN_VALUE;
        for(int i = 0; i < a.length; i++) {
            sum += a[i];
            result = Math.max(result, sum);
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

/***

Reference: https://wcipeg.com/wiki/Prefix_sum_array_and_difference_array
https://www.geeksforgeeks.org/prefix-sum-array-implementation-applications-competitive-programming/



***/