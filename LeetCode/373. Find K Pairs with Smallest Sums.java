class Solution {
    
    class Tuple implements Comparable<Tuple> {
        int x, y, val;
        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple that) {
            return this.val - that.val;
        }
    }

    
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<int[]>();
        PriorityQueue<Tuple> queue = new PriorityQueue<Tuple>();
        int m = nums1.length;
        int n = nums2.length;
        if(m == 0 || n == 0 || k <= 0) return result;
        
        for(int j = 0; j < n; j++)
            queue.offer(new Tuple(0, j, nums1[0] + nums2[j]));
        
        for(int i = 0; i < Math.min(k, m * n); i++) {
            Tuple tuple = queue.poll();
            result.add(new int[]{nums1[tuple.x], nums2[tuple.y]});
            if(tuple.x == m - 1) continue;
            queue.offer(new Tuple(tuple.x + 1, tuple.y, nums1[tuple.x + 1] + nums2[tuple.y]));
        }
        return result;
    }
}