/**
 * Ideone: https://ideone.com/qKikpJ
 */
class Solution {
    public static int countTriplets(int[] arr, int sum) {
        int n = arr.length;
        int count = 0;

        Arrays.sort(arr);

        for (int i = 0; i < n - 2; i++) {
            int j = i + 1, k = n - 1;

            while (j < k) {
                if (arr[i] + arr[j] + arr[k] >= sum) {
                    k--;
                } else {
                    count += (k - j);
                    j++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 1, 3, 4, 7};
        int sum = 12;

        System.out.println(countTriplets(arr, sum));
    }
}
