import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the jimOrders function below.
    static int[] jimOrders(int[][] orders) {
       
        TreeMap<Integer, TreeSet<Integer>> tmap = new TreeMap<Integer, TreeSet<Integer>>();
        for(int i = 0; i < orders.length; i++) {
            int serveTime = orders[i][0] + orders[i][1];
            if(tmap.containsKey(serveTime)) {
                tmap.get(serveTime).add(i + 1);
            } else {
                TreeSet<Integer> orderNumber = new TreeSet<Integer>();
                orderNumber.add(i + 1);
                tmap.put(serveTime, orderNumber);
            }
        }
        int result[] = new int[orders.length];
        int i = 0;
         for (TreeSet<Integer> orderNumbers: tmap.values()) {
            for(Integer order : orderNumbers) 
                result[i++] = (int) order; 
         }
            
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] orders = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] ordersRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int ordersItem = Integer.parseInt(ordersRowItems[j]);
                orders[i][j] = ordersItem;
            }
        }

        int[] result = jimOrders(orders);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
