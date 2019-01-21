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