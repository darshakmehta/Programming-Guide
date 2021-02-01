import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static List<Integer> findCommonElements(int[] arr1, int[] arr2, int[] arr3) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int n3 = arr3.length;
        List<Integer> result = new ArrayList<Integer>();

        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2 && k < n3) { // O(n1 + n2 + n3)
            int temp = arr1[i++];

            while (j < n2 && temp > arr2[j]) {
                j++;
            }

            if (j < n2 && arr2[j] == temp) {
                j++;
                while (k < n3 && temp > arr3[k]) {
                    k++;
                }

                if (k < n3 && arr3[k] == temp) {
                    k++;
                    result.add(temp);
                }
            }
        }

        return result;
    }

    // Clean Improvement to above logic
    public static List<Integer> improvedFindCommonElements(int[] arr1, int[] arr2, int[] arr3) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int n3 = arr3.length;
        List<Integer> result = new ArrayList<Integer>();

        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2 && k < n3) { // O(n1 + n2 + n3)
            if (arr1[i] == arr2[j] && arr1[i] == arr3[k]) {
                result.add(arr1[i]);
                i++; j++; k++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }

        return result;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt(); // size of first array
        int n2 = sc.nextInt(); // size of second array
        int n3 = sc.nextInt(); // size of third array

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        int[] arr3 = new int[n3];

        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }
        for (int i = 0; i < n3; i++) {
            arr3[i] = sc.nextInt();
        }

        List<Integer> result = findCommonElements(arr1, arr2, arr3);
        System.out.print("Common elements are: ");

        for (int el : result) {
            System.out.print(el + " ");
        }
        System.out.println();

        // Clean Improved Solution
        result = improvedFindCommonElements(arr1, arr2, arr3);
        System.out.print("Common elements are: ");

        for (int el : result) {
            System.out.print(el + " ");
        }
        System.out.println();
    }
}

// Solution: https://ideone.com/lHbs8U

/*
Testcases:

3 5 4
1 5 5
3 4 5 5 10
5 5 10 20

6 5 8
1 5 10 20 40 80
6 7 20 80 100
3 4 15 20 30 70 80 120
 */

/**
 * Note: Time complexity of the above solution is O(n1 + n2 + n3). In the worst case, the largest sized array may have
 * all small elements and middle-sized array has all middle elements.
 */


/**
 * 2nd Approach using Intersection of two arrays => Time Complexity: O(n1 + n2 + n3)
 * Steps:
 * 1. Find intersection of first two arrays.
 * 2. Find interesction of resultant array from step 1 and third array
 *
 * Disadvantage: Requires extra space to store temporary results
 */
