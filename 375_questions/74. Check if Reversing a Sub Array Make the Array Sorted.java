/**
 * Ideone: https://ideone.com/7NODN8
 */
class Solution {
    public static void swap(int nums[], int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static boolean sortArr(int[] arr, int n) {
        int x = -1, y = -1;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i+1]) {
                if (x == -1) {
                    x = i;
                }
                y = i+1;
            }
        }

        if (x == -1) {
            return true;
        }

        while (x < y) {
            swap(arr, x++, y--);
        }

        for (int i = 0; i < n-1; i++) {
            if (arr[i] > arr[i+1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int arr[] = { 10,20,30,40,4,3,2,50,60,70 };
        int n = arr.length;

        if (sortArr(arr, n)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}

/**
 * The first part is increasing subarray, then decreasing subarray, and then again increasing subarray
 * Ideone: https://ideone.com/IEaqr6
 */
class Solution {
    public static boolean sortArr(int[] arr, int n) {
        if (n == 1) {
            return true;
        }

        // Find first increasing part
        int i = 1;
        for (; arr[i - 1] < arr[i] && i < n; i++) {
            if (i == n) {
                return true;
            }
        }

        // Find reversed part
        int j = i;
        while (j < n && arr[j] < arr[j - 1]) {
            if (i > 1 && arr[j] < arr[i - 2]) {
                return false;
            }
            j++;
        }

        if (j == n) {
            return true;
        }

        // Find last increasing part
        int k = j;

        // To handle cases like {1,2,3,4,20,9,16,17}
        if (arr[k] < arr[i - 1]) {
            return false;
        }

        while (k > 1 && k < n) {
            if (arr[k] < arr[k - 1]) {
                return false;
            }
            k++;
        }
        return true;
    }

    public static void main(String[] args) {
        int arr[] = { 10,20,30,40,4,3,2,50,60,70 };
        int n = arr.length;

        if (sortArr(arr, n)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}
