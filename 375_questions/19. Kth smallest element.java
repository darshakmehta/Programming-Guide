class Solution {
    public int findKthLargest(int[] nums, int k) {
        final Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int val : arr) {
            pq.offer(val);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}

/**
TODO: Improve complexity
**/
