import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gridChallenge function below.
    static String gridChallenge(String[] grid) {
        if(grid.length == 1)
            return "YES";
        for(int i = 0; i < grid.length; i++) {
            char c[] = grid[i].toCharArray();
            Arrays.sort(c);
            grid[i] = String.valueOf(c);
        }
        boolean flag = false;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid.length - 1; j++) {
                // System.out.println(i + " " + j + " "  + grid[j].charAt(i) + " " + grid[j + 1].charAt(i));
                // System.out.println(grid[j].charAt(i) <= grid[j + 1].charAt(i));
                if(grid[j].charAt(i) <= grid[j + 1].charAt(i)) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if(!flag)
                break;
        }
           if(flag)
               return "YES";
            else
                return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String[] grid = new String[n];

            for (int i = 0; i < n; i++) {
                String gridItem = scanner.nextLine();
                grid[i] = gridItem;
            }

            String result = gridChallenge(grid);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
