class Solution {
    public boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        
        for(int num : A)
            hmap.put(num, hmap.getOrDefault(num, 0) + 1);
        
        /* Check if there are even number of 0's */
        Integer x = hmap.get(0);
        if(x != null) {
            if(x % 2 != 0)
                return false;
        }
        
        Arrays.sort(A);
        
        for(int i = 0; i < A.length; i++) {
            if(A[i] == 0) continue;
            
            int mul = A[i] * 2;
            
            if(hmap.containsKey(A[i]) && hmap.get(A[i]) > 0) {
                if(hmap.containsKey(mul) && hmap.get(mul) > 0) {
                    hmap.put(mul, hmap.get(mul) - 1);
                    hmap.put(A[i], hmap.get(A[i]) - 1);
                } else if(A[i] % 2 == 0 && hmap.containsKey(A[i] / 2) && hmap.get(A[i] / 2) > 0) {
                    hmap.put(A[i] / 2, hmap.get(A[i] / 2) - 1);
                    hmap.put(A[i], hmap.get(A[i]) - 1);
                } else {
                    return false;
                }
            }  
        }
        
        
        return true;
    }
}