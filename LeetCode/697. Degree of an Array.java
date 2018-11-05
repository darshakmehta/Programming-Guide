class Solution { //Incorrect Solution
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        Set<Integer> set = new HashSet<Integer>();
        int count = 1;
        int result = nums[0];
        set.add(nums[0]);
        for(int i : nums) {
            hmap.put(i, hmap.getOrDefault(i, 0) + 1);
            if(hmap.get(i) > count) {
                count = hmap.get(i);
                result = i;
            } 
        }
        
        int minIndex = 0;
        for(int i = 0; i < nums.length; i++) { //Find first occurence of result
            if(nums[i] == result) {
                minIndex = i;
                break;
            }
        }
        int maxIndex = 0;
        for(int i = nums.length - 1; i >= 0; i--) {  //Find last occurence of result
            if(nums[i] == result)  {
                maxIndex = i;
                break;
            }
        }
        return maxIndex - minIndex + 1;
            
    }
}

class Solution { //Correct solution
    public int findShortestSubArray(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
           if (!map.containsKey(nums[i])){
               map.put(nums[i], new int[]{1, i, i});  
               // the first element in array is degree, second is first index of this key, third is last index of this key
           } else {
               int[] temp = map.get(nums[i]);
               temp[0]++;
               temp[2] = i;
           }
        }
        int degree = Integer.MIN_VALUE, res = Integer.MAX_VALUE;
        for (int[] value : map.values()){
            if (value[0] > degree){
                degree = value[0];
                res = value[2] - value[1] + 1;
            } else if (value[0] == degree){
                res = Math.min( value[2] - value[1] + 1, res);
            } 
        }
        return res;
    }
}