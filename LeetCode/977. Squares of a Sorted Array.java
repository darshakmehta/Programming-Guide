class Solution {
    public int[] sortedSquares(int[] A) {
        for ( int i = 0; i < A.length; i++ ) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        
        return A;
    }
}

class Solution {
    public int[] sortedSquares(int[] A) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        
        for ( int i = 0; i < A.length; i++ ) {
                queue.offer(A[i] * A[i]);
        }
        
        for ( int i = 0; i < A.length; i++ ) {
            A[i] = queue.poll();
        }
        
        return A;
    }
}

/* Reference: https://leetcode.com/problems/squares-of-a-sorted-array/discuss/221922/Java-two-pointers-O(N) */

class Solution {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        int i = 0, j = n - 1;
        for (int p = n - 1; p >= 0; p--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                result[p] = A[i] * A[i];
                i++;
            } else {
                result[p] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }
}