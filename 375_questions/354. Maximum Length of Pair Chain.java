class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        int count = 1;

        for (int i = 0, j = 1; j < pairs.length; j++) {
            if (pairs[i][1] < pairs[j][0]) {
                count++;
                i = j;
            }
        }
        return count;
    }
}

/**
 * TODO:
 * 1. Write solution in DP array following Longest Increasing subsequence.
 */
