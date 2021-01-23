import java.util.*;
import java.lang.*;
import java.io.*;

class Result {
    float max_avg;
    int start;
    int end;

    public Result(float max_avg, int start, int end) {
        this.max_avg = max_avg;
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println();

        System.out.print();
        for (int i = result.start; i <= result.end; i++) {
            System.out.print();
        }
        System.out.println();
    }
}
