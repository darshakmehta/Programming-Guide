import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int last_x = -1, last_y = -1;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                last_x = i;
            } else if (arr[i] == y) {
                last_y = i;
            }

            if (last_x != -1 && last_y != -1) {
                result = Math.min(result, Math.abs(last_x - last_y));
            }
        }

        System.out.println("Minimum distance: " + result);
    }
}

// Solution: https://ideone.com/608Qq4
// TODO: Print actual Solution
