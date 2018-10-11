/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    for(var i = 0; i < nums.length; i++) {
        var x = target - nums[i]; 
        for(var j = 0; j < nums.length; j++) {
            if(i !== j && x === nums[j]) {
                return [i, j];
            }
        }
    }
}