/**
 * Ideone: https://ideone.com/H245rL
 */
class Solution {
    public static void findDuplicate(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            arr[arr[i] % len] = arr[arr[i] % len] + len;
        }

        for (int i = 0; i < len; i++) {
            if (arr[i] >= len * 2) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 0, 4, 3, 2, 7, 8, 2, 3, 1 };

        System.out.println(findDuplicate(arr));
    }
}

/**
 * TODO:
 * 1. Write efficient approach
 */
