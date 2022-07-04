/* Update:
Passes 315/318 test cases and time limit exceeds for the rest scenarios.
Link: https://leetcode.com/submissions/detail/737909817/
/* TODO: Check for some improvements */

class Solution { // Not working solution
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();

        // Add all values in a map
        for (int val : nums) {
            if (!hmap.containsKey(val)) {
                hmap.put(val, 1);
            } else {
                hmap.put(val, hmap.get(val) + 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; i != j && j < nums.length; j++) {
                int x = nums[i] + nums[j];

                // to get sum = 0 we need to look for -ve value of x
                if (hmap.containsKey(-x)) {
                    int count = hmap.get(-x);
                    if (count == 1 && (nums[i] == -x || nums[j] == -x)) {
                        continue;
                    } else if (count == 2 && (nums[i] == -x && nums[j] == -x)) {
                        continue;
                    } else {
                        List<Integer> list = new ArrayList<Integer>();
                        int[] temp = new int[3];
                        temp[0] = nums[i]; temp[1] = nums[j]; temp[2] = -x;
                        Arrays.sort(temp);

                        list.add(temp[0]);
                        list.add(temp[1]);
                        list.add(temp[2]);

                        if (!result.contains(list)) {
                            result.add(list);
                        }
                    }
                }
             }
        }
        return result;
    }
}

/*
Simpler working solution using HashSet
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result  = new HashSet<>();
        int n = nums.length;

        if (n == 0) {
            return new ArrayList<>(result);
        }

        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                } else if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                }
            }
        }
        return new ArrayList<>(result);
    }
}
