import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws java.lang.Exception {
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

        System.out.println("Minimum distance betweeen x: " + x + " and y: " + y + " is " + result);
    }
}

// Solution: https://ideone.com/608Qq4

/**
 * Print actual Solution
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class Pair {
    int x;
    int y;
    int minDistance;

    public Pair(int x, int y, int minDistance) {
        this.x = x;
        this.y = y;
        this.minDistance = minDistance;
    }
}

class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int last_x = -1, last_y = -1;
        Pair pair = new Pair(-1, -1, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                last_x = i;
            } else if (arr[i] == y) {
                last_y = i;
            }

            if (last_x != -1 && last_y != -1) {
                int distance = Math.abs(last_x - last_y);
                if (pair.minDistance > distance) {
                    pair.minDistance = distance;
                    pair.x = last_x;
                    pair.y = last_y;
                }
            }
        }

        System.out.println("Minimum distance betweeen x: " + x + " and y: " + y + " is " + pair.minDistance);

        System.out.println("x: " + x + " is found at index: " + pair.x);
        System.out.println("y: " + y + " is found at index: " + pair.y);
    }
}

// Solution: https://ideone.com/fHauPl

/*
Testcases:

8 3 2
2 5 3 5 4 4 2 3

2 1 2
1 2

3 3 5
3 4 5

12 3 6
3 5 4 2 6 5 6 6 5 4 8 3
 */
