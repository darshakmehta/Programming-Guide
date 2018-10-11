import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the happyLadybugs function below.
    static String happyLadybugs(String b) {
        boolean _ = false;
        char ch[] = b.toCharArray();
        List<Character> list = new ArrayList<Character>();
        Map<Character, Integer> hmap = new HashMap<Character, Integer>();
        
        for(Character c: ch) {
            if(c.equals('_')) {
                _ = true;
            } else {
                int count = 1;
                if(hmap.containsKey(c)) {
                    count = hmap.get(c) + 1;
                }
                hmap.put(c, count);
                if(hmap.get(c) >=2) {
                    if(list.contains(c)) {
                        list.remove(c); 
                    }         
                } else {
                    list.add(c);
                }
            }
        }
        boolean flag = true;
        if(list.size() > 0) {
            return "NO";
        } else if(_ && (list.size() == 0)) {
            return "YES";
        } else {
            for(int i = 1; i < ch.length - 1; i++) {
                if(ch[i - 1] != ch[i] && ch[i + 1] != ch[i]) {
                    return "NO";
                }
            }
            return "YES";
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int gItr = 0; gItr < g; gItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String b = scanner.nextLine();

            String result = happyLadybugs(b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
