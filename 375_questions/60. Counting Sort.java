/**
 * Ideone: https://ideone.com/2R7ZqF
 */
class Solution {
    public static char[] sort(char[] arr) {
        int n = arr.length;
        char min = arr[0];
        char max = arr[0];

        // find min. element
        for (int i = 1; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // find the # of times character exist
        int[] dp = new int[max-min+1];
        for (int i = 0; i < n; i++) {
            dp[arr[i] - min]++;
        }

        // generate output arr based on characters count
        char[] output = new char[n];
        for (int i = min, j = 0; i < max; i++) {
            while (dp[i] > 0) {
                output[j++] = (char)(i + min);
                dp[i]--;
            }
        }
        return output;
    }
    public static void main(String[] args) {
        char arr[] = { 'g', 'e', 'e', 'k', 's', 'f', 'o',
                'r', 'g', 'e', 'e', 'k', 's' };

        char[] result = sort(arr);

        System.out.print("Sorted character array is " + Arrays.toString(result));
    }
}
