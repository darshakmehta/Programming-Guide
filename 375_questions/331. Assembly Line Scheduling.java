import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static int carAssembly(int[][] a, int [][] t, int[] e, int[] x) {
        int numOfStation = a[0].length;
        int[] dp1 = new int[numOfStation];
        int[] dp2 = new int[numOfStation];

        // Base case
        // time taken to reach first station in line 1
        dp1[0] = e[0] + a[0][0];

        // time taken to reach first station in line 2
        dp2[0] = e[1] + a[1][0];

        for (int i = 1; i < numOfStation; i++) {
            dp1[i] = Math.min(dp1[i-1] + a[0][i], dp2[i-1] + a[0][i] + t[1][i]);
            dp2[i] = Math.min(dp2[i-1] + a[1][i], dp1[i-1] + a[1][i] + t[0][i]);
        }

        return Math.min(dp1[numOfStation-1] + x[0], dp2[numOfStation-1] + x[1]);
    }

    public static void main (String[] args) {
        int a[][] = {{4, 5, 3, 2},
                {2, 10, 1, 4}};
        int t[][] = {{0, 7, 4, 5},
                {0, 9, 2, 8}};
        int e[] = {10, 12}, x[] = {18, 7};

        System.out.println(carAssembly(a, t, e, x));

    }
}

/**
 * Improvement: We only rely on last values in the dp[].
 */
import java.util.*;
        import java.lang.*;
        import java.io.*;

class Solution {
    public static int carAssembly(int[][] a, int [][] t, int[] e, int[] x) {
        int numOfStation = a[0].length;

        // Base case
        // time taken to reach first station in line 1
        int first = e[0] + a[0][0];

        // time taken to reach first station in line 2
        int second = e[1] + a[1][0];

        for (int i = 1; i < numOfStation; i++) {
            int up = Math.min(first + a[0][i], second + a[0][i] + t[1][i]);
            int down = Math.min(second + a[1][i], first + a[1][i] + t[0][i]);

            first = up;
            second = down;
        }

        return Math.min(first + x[0], second + x[1]);
    }

    public static void main (String[] args) {
        int a[][] = {{4, 5, 3, 2},
                {2, 10, 1, 4}};
        int t[][] = {{0, 7, 4, 5},
                {0, 9, 2, 8}};
        int e[] = {10, 12}, x[] = {18, 7};

        System.out.println(carAssembly(a, t, e, x));

    }
}

/**
 * TODO: Print path covered in the assembly line
 */
