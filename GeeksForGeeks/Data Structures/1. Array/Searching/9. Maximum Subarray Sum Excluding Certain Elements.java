import java.util.*;
import java.lang.*;
import java.io.*;

class Result {
    int max_sum;
    int start;
    int end;

    public Result(int max_sum, int start, int end) {
        this.max_sum = max_sum;
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public static Result maxSubArrExcludeXElements(int[] nums1, int[] nums2) { // O(n2) Space and O(max(n1, n2)) Time
        int n1 = nums1.length;
        int n2 = nums2.length;

        Set<Integer> hset = new HashSet<Integer>();                     // O(n2) space

        for (int i = 0; i < n2; i++) {                                  // O(n2) time
            hset.add(nums2[i]);
        }

        Result result = new Result(0, 0, 0);
        int max_ending_here = 0, start = 0;

        for (int i = 0; i < n1; i++) {                                 // O(n1) Time
            max_ending_here = max_ending_here + nums1[i];
            if (max_ending_here < 0 || hset.contains(nums1[i])) {
                start = i + 1;
                max_ending_here = 0;
            } else if (result.max_sum < max_ending_here) {
                result.max_sum = max_ending_here;
                result.start = start;
                result.end = i;
            }
        }

        return result;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        Result result = maxSubArrExcludeXElements(arr1, arr2);

        System.out.println("Maximum Subarray sum excluding certain elements is between " + result.start + " and "
                + result.end);

        System.out.print("Maximum sum subarray is: ");
        for (int i = result.start; i <= result.end; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
    }
}

// Solution: https://ideone.com/r6yVyz

/*
Testcases:
5 4
1 7 -10 6 2
5 6 7 1

5 3
3 4 5 -4 6
1 8 5
*/
