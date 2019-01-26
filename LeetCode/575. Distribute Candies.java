class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<Integer>();
        
        for (int candy : candies)
            set.add(candy);
        
        return Math.min(candies.length / 2, set.size());
    }
}