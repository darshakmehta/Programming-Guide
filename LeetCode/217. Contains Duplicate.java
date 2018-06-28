class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        boolean flag = false;
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(hmap.containsKey(nums[i])) {
                flag = true;
                break;
            } else {
                hmap.put(nums[i], 1);
            }
        }
        return flag;
    }
}