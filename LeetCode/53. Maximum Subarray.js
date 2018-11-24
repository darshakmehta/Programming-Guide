/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    let maxSoFar = -Infinity;
	let currMax = 0;

	for(let num of nums) {
		currMax = currMax + num;
		if(currMax < num) {
			currMax = num;
		}
		maxSoFar = Math.max(maxSoFar, currMax);
	}
	return maxSoFar;
};

/* Solution similar to Java submission */

var maxSubArray = function(nums) {
    let maxSoFar = -Infinity;
	let currMax = -Infinity;

	for(let num of nums) {
		currMax = Math.max(num, currMax + num);
		maxSoFar = Math.max(maxSoFar, currMax);
	}
	return maxSoFar;
};
