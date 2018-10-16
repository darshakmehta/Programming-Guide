class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // Arrays.sort(nums); //not necessary
        if(nums.length == 0) return result;
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }
    
    public void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        if(tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                backtrack(result, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}