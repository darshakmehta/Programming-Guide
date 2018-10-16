class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(candidates.length == 0) return result;
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, 0, target);
        return result;
    }
    
    public void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start, int target) {
        if(target < 0) return;
        else if(target == 0) result.add(new ArrayList<>(tempList));
        else {
            for(int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrack(result, tempList, nums, i, target - nums[i]);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}