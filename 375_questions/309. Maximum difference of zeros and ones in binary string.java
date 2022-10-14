/**
 * Using Kadane's Algorithm - Since we know 0 will increase the result and 1 will decrease the answer.
 * We can easily replace 0 by 1 and 1 by -1 and find maxSum.
 */
int maxSubstring(String S) {
    int len = S.length();
    char[] c = S.toCharArray();
    int[] arr = new int[len];

    // Build helper array.
    for (int i = 0; i < len; i++) {
     arr[i] = c[i] == '1' ? -1 : 1;
    }

    int maxSoFar = arr[0], currMax = arr[0];

    // Kadane's Algo - Find maximum substring.
    for (int i = 1; i < len; i++) {
        currMax = Math.max(currMax + arr[i], arr[i]);
        maxSoFar = Math.max(maxSoFar, currMax);
    }

    return maxSoFar;
}