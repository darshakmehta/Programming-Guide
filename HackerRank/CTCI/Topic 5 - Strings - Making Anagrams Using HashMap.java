import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int count = 0;
        int result = 0;
        Map<Character, Integer> hmap = new HashMap<Character, Integer>();
        for(int i = 0; i < a.length(); i++) {
            count = 1;
            char c = a.charAt(i);
            if(hmap.containsKey(c)) {
                count = hmap.get(c);
                count++;
            }
            hmap.put(c, count);
            result++;
        }        
        
        for(int i = 0; i < b.length(); i++) {
            char c = b.charAt(i);
            if(hmap.containsKey(c)) {
                count = hmap.get(c);
                if(count > 0)
                    result--;
                else
                    result++;
                hmap.put(c, --count);
            } else {
                result++;
            }
        }
        
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
