/* TODO: Check some implementation */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i : nums) set.add(i);
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; i != j && j < nums.length; j++) {
                    int x = nums[i] + nums[j];
                    if(set.contains(-x)) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]); list.add(nums[j]); list.add(-x);
                        
                        //Better implementation to check if list already exist?
                        if(!result.contains(list)) {
                            result.add(list);
                        }
                    }
            }
        }
        return result;
    }
}


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        for(int i = 0; i < nums.length - 2; i++) {
            if(nums[i] > 0) break;
            if(i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                int l = i + 1, h = nums.length - 1, sum = 0 - nums[i];
                while(l < h) {
                    if(nums[l] + nums[h] == sum) {
                        result.add(Arrays.asList(nums[i], nums[l], nums[h]));
                        while(l < h && nums[l] == nums[l + 1]) l++;
                        while(l < h && nums[h] == nums[h - 1]) h--;
                        l++; h--;
                    } else if(nums[l] + nums[h] < sum) {
                        l++;
                    } else {
                        h--;
                    }
                }
            }
            
        }
        return result;
    }
}