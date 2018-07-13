import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        StringBuilder sb = new StringBuilder(s);
        StringBuilder hours = new StringBuilder();
        for(int i = 0; i < 2; i++) {
            hours.append(sb.charAt(i));
        }
        int x = Integer.parseInt(hours.toString());
        if(sb.charAt(8) == 'P') {
            if(x != 12) {
                x += 12;
                String temp = x + "";
                sb.setCharAt(0, temp.charAt(0));
                sb.setCharAt(1, temp.charAt(1));
            }
        } else {
            if(x == 12) {
                sb.setCharAt(0, '0');
                sb.setCharAt(1, '0');
            }
        }
        sb.deleteCharAt(s.length() - 1);
        sb.deleteCharAt(s.length() - 2);
        return sb.toString();

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
