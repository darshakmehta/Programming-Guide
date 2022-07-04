class Solution {
    public int findKthLargest(int[] nums, int k) {
        final Queue<Integer> pq = new PriorityQueue<>();

        for (int val : nums) {
            pq.offer(val);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
