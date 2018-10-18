class Solution {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> result = new ArrayList<String>();
		if(lower == Integer.MAX_VALUE) return result; 
		int next = lower;

		for(int num : nums) {
			if(num < next) continue;
			if(num == next) {
				next++;
				continue;
			}
			result.add(getRange(next, nums[i] - 1));
			if(nums[i] == Integer.MAX_VALUE) return result;
			next = nums[i] + 1;
		}	

		if(next <= upper) {
			result.add(getRange(nextl, upper));
		}
		return result;
	}

	public String getRange(int num1, int num2) {
		return num1 == num2 ? String.valueOf(num1) : String.format("%d->%d", num1, num2);
	}
}