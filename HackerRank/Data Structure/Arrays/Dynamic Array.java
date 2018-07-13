import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the dynamicArray function below.
     */
    static int[] dynamicArray(int n, int[][] queries) {
        List<Integer> list[] = new List[n];
        int lastAnswer = 0;
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            list[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < queries.length; i++) {
            int query = queries[i][0];
            int x = queries[i][1];
            int y = queries[i][2];
            
            if(query == 1) {
                int a = (x ^ lastAnswer) % n;
                list[a].add(y);      
            } else if(query == 2) {
                int a = (x ^ lastAnswer) % n;
                lastAnswer = list[a].get(y % list[a].size());
                result.add(lastAnswer);
            }
        }
        int answerArr[] = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answerArr[i] = result.get(i);
        }
        return answerArr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nq[0].trim());

        int q = Integer.parseInt(nq[1].trim());

        int[][] queries = new int[q][3];

        for (int queriesRowItr = 0; queriesRowItr < q; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 3; queriesColumnItr++) {
                int queriesItem = Integer.parseInt(queriesRowItems[queriesColumnItr].trim());
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = dynamicArray(n, queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
