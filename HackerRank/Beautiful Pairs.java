import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the beautifulPairs function below.
   static int beautifulPairs(int[] A, int[] B) {
        
        Set<Integer> leftSet = new LinkedHashSet<Integer>();
        Set<Integer> rightSet = new LinkedHashSet<Integer>();
       int count = 0;
       for(int i = 0; i < A.length; i++) {
           for(int j = 0; j < B.length; j++ ) {
               if(A[i] == B[j] && (!leftSet.contains(i) && (!rightSet.contains(j)))) {
                    leftSet.add(i);
                    rightSet.add(j);     
                    count++;
               }        
           }
       }
       
       if(count == A.length) {
           return count - 1;
       } else {
           return count + 1;
       }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int AItem = Integer.parseInt(AItems[i]);
            A[i] = AItem;
        }

        int[] B = new int[n];

        String[] BItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
        }

        int result = beautifulPairs(A, B);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
