/**
*   Return the second largest number in the array.
*   @param {Number[]} nums - An array of numbers.
*   @return {Number} The second largest number in the array.
**/
function getSecondLargest(nums) {
    // Complete the function
    nums.sort((x,y) => (x < y));
    let large = nums[0];
    while(true) {
        let removed = nums.shift();
        if(removed != large) {
            large = removed;
            break;
        }
    }
    return large;
}