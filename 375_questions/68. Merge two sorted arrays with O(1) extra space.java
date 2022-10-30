/**
 * Ideone: https://ideone.com/AodJXD
 */
class Solution {
    static int arr1[] = new int[]{ 1, 5, 9, 10, 15, 20 };
    static int arr2[] = new int[]{ 2, 3, 8, 13 };

    public static void mergeTwoSortedArr(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;

        int i = 0;

        while (arr1[n-1] > arr2[0]) {
            if (arr1[i] > arr2[0]) {
                int temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
                Arrays.sort(arr2);
            }
            i++;
        }
    }

    public static void main(String[] args) {
        mergeTwoSortedArr(arr1.length, arr2.length);

        System.out.print("After Merging \nFirst Array: ");
        System.out.println(Arrays.toString(arr1));

        System.out.print("Second Array:  ");
        System.out.println(Arrays.toString(arr2));
    }
}

/**
 * TODO:
 * 1. Using Insertion Sort
 */
