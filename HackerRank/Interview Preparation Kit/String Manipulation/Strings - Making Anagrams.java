/* HashMap Based */ 
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

/* Array Based */ 
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {
    public static int numberNeeded(String first, String second) {
        int a[] = new int [27];
        int b[] = new int [27];
        int ans = 0;
      
        for(int i = 0; i < first.length(); i++){
            int value = (int) first.charAt(i);
            a[value - 96]++;
        }
        for(int i = 0; i < second.length(); i++){
            int value = (int) second.charAt(i);
            b[value - 96]++;
        }
        /*for(int i = 1; i<a.length; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
        for(int i = 1; i<b.length; i++){
            System.out.print(b[i]+" ");
        }*/
        for(int i = 1; i<a.length; i++){
            ans += (Math.abs(a[i] - b[i]));
        }
        
        return ans;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
