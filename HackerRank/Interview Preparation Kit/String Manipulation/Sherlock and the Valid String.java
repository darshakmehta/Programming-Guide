import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        if(s.length() == 1) return "YES";
        Map<Character, Integer> hmap = new HashMap<Character, Integer>();
        for(char c : s.toCharArray())
            hmap.put(c, hmap.getOrDefault(c, 0) + 1);
        int firstCount = hmap.get(s.charAt(0));
        char c = 'a';
        int result = 0;
        for(int i = 0; i < 26; i++, c++) {
            if(hmap.containsKey(c)) {
                if(hmap.get(c) != firstCount) {
                    result += Math.abs(hmap.get(c) - firstCount);
                }
            } 
            /* To be tested
            if(hmap.containsKey(c)) {
                if(hmap.get(c) != firstCount) {
                    if(!flag && hmap.get(c) == 1) {
                        flag = true;
                    } else
                        result += Math.abs(hmap.get(c) - firstCount);
                }
            } 
            */
        }
        if(result > 1)
            return "NO";
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

/***

TODO:
Fails for test case
1. aaab ("YES") since we can remove entire occurences of b

***/