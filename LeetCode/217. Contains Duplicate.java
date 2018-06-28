class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        boolean flag = false;
        int max = -99999;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max)
                max = nums[i];
        }
        System.out.println(max);
        int a[] = new int[max+1];
        for(int i = 0; i < nums.length; i++) {
            a[nums[i]]++;
        }
        for(int i = 1; i <= max; i++) {
            if(a[i] != 2) {
            
            } else {
                flag = true;
                break;
            }
        }
        return flag;
    }
}