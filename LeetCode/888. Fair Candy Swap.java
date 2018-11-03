class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        
        Set<Integer> set = new HashSet<Integer>();
        int[] result = new int[2];
        int sumA = 0, sumB = 0;
        
        for(int num : A) sumA += num;
        for(int num : B) {
            set.add(num);
            sumB += num;   
        }
        
        int diff = (sumA + sumB) / 2; //Possible candies on both side
        for(int num : A) {
            if(set.contains(diff - (sumA - num))) {
                result[0] = num;
                result[1] = diff - (sumA - num);
                return result;
            }
        }
        return result;
    }
}