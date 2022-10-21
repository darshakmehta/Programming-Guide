class Solution {
    static int minJumps(int[] arr) {
        int n = arr.length;

        if (n <= 1) {
            return 0;
        }

        int minJump = 0;
        int currEnd = 0;
        int currFarthest = 0;

        for (int i = 0; i < n; i++) {
            currFarthest = Math.max(currFarthest, i + arr[i]);

            // cannot move ahead
            if (currFarthest == i) {
                return -1;
            }

            // found a jump to the end
            if (currFarthest >= n - 1) {
                minJump++;
                break;
            }

            // update window end
            if (i == currEnd) {
                currEnd = currFarthest;
                minJump++;
            }
        }

        return minJump;
    }
}
