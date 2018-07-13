import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maxSubarray function below.
    static int[] maxSubarray(int[] arr) {
            int currMax = arr[0];
            int maxSoFar = arr[0];
            int sum = 0;
            if(arr[0] > 0)
                sum += arr[0];
            int max = arr[0];
            for(int i = 1; i < arr.length; i++) {
                currMax = Math.max(arr[i], currMax + arr[i]);
                maxSoFar = Math.max(maxSoFar, currMax);
                if(arr[i] > 0) {
                    sum+= arr[i];
                } else {
                    if(max < arr[i])
                        max = arr[i];
                }
            }
            int result[] = new int[2];
            if(maxSoFar > 0) {
                result[0] = maxSoFar;
                result[1] = sum;
            } else {
                result[0] = maxSoFar;
                result[1] = max;
            }
        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int[] result = maxSubarray(arr);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
