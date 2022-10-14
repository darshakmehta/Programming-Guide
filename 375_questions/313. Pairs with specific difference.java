class Solution {
    public static int maxSumPairWithDifferenceLessThanK(int arr[], int N, int K) {

        // Make sure smallest difference pair are together
        Arrays.sort(arr);

        int maxSum = 0;

        // traverse from the end since if right to left pair matches it will
        // always give maximum sum compare to left to right pair.
        for (int i = N - 1; i > 0; i--) {
            if (arr[i] - arr[i - 1] < K) {
                maxSum += arr[i] + arr[i-1];
                // since we already found a pair skip one more place
                i--;
            }
        }

        return maxSum;
    }
}