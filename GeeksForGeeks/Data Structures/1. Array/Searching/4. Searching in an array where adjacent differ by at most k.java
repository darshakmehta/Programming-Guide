import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static int findElement(int[] nums, int x, int k) { // O(n)
        int n = nums.length;
        int index = -1;

        for (int i = 0; i < n; ) {
            if (nums[i] == x) {
                index = i;
                break;
            }
            int temp = (int) Math.ceil((Math.abs(nums[i] - x)/k));
            i += temp == 0 ? 1 : temp;
        }

        return index;
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt(); // element differs by k
        int x = sc.nextInt(); // element to search

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = findElement(arr, x, k);
        if (result != -1) {
            System.out.println("Element x: " + x + " found at index: " + result);
        } else {
            System.out.println("Element x: " + x + " not found");
        }
    }
}

// Solution: https://ideone.com/zLxHcn

/*
Testcases:

5 1 6
4 5 6 7 6

6 20 60
20 40 50 70 70 60

6 20 30
20 40 50 70 70 60

6 20 10
20 40 50 70 70 60

6 20 80
20 40 50 70 70 60
 */
