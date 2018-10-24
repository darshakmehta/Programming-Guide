class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                hmap.put(sum, hmap.getOrDefault(sum, 0) + 1);
            }
        }
        int result = 0;
        for(int i = 0; i < C.length; i++) {
            for(int j = 0; j < D.length; j++) {
                int sum = -1 * (C[i] + D[j]);
                result += hmap.getOrDefault(sum, 0);
            }
        }
        
        return result;
    }
}