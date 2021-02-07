import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static List<Integer> leaders(int[] nums) { // Time: O(n)
        int n = nums.length;
        List<Integer> list = new ArrayList<Integer>();

        int max = nums[n - 1];
        list.add(max);

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > max) {
                list.add(nums[i]);
                max = Math.max(max, nums[i]);
            }
        }

        return list;
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        List<Integer> list = leaders(arr);

        System.out.print("Leaders in array are: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}

// Solution: https://ideone.com/EMuJWX

/*
Testcases:

6
16 17 4 3 5 2
*/
