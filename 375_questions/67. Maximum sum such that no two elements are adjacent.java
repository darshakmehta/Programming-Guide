/**
 * Ideone: https://ideone.com/rWUTp9
 */
class Solution {
    public static int findMaxSum(int[] arr) {
        int n = arr.length;
        int include = arr[0];
        int exclude = 0;

        for (int i = 1; i < n; i++) {
            int exclude_new = Math.max(include, exclude);

            include = exclude + arr[i];
            exclude = exclude_new;
        }
        return Math.max(include, exclude);
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 5, 5, 10, 100, 10, 5 };
        System.out.println(findMaxSum(arr));
    }
}
