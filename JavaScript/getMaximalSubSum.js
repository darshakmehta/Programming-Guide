"use strict";

let getMaxSubSum = (arr) => {
	let maxSoFar = -Infinity;
	let currMax = 0;

	for(let i = 0; i < arr.length; i++) {
		currMax = currMax + arr[i];
		if(currMax < arr[i]) {
			currMax = arr[i];
		}
		maxSoFar = Math.max(maxSoFar, currMax);
	}
	return maxSoFar;
}

console.log(getMaxSubSum([-1, 2, 3, -9]));
console.log(getMaxSubSum([2, -1, 2, 3, -9]));
console.log(getMaxSubSum([-1, 2, 3, -9, 11]));
console.log(getMaxSubSum([-2, -1, 1, 2]));
console.log(getMaxSubSum([100, -9, 2, -3, 5]));
console.log(getMaxSubSum([1, 2, 3]));

//Wiki: http://en.wikipedia.org/wiki/Maximum_subarray_problem