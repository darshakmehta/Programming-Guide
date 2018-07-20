/*
 * Modify and return the array so that all even elements are doubled and all odd elements are tripled.
 * 
 * Parameter(s):
 * nums: An array of numbers.
 */
function modifyArray(nums) {
    let ans = nums.map((num) => {
        if(num % 2 == 0)
            return num * 2;
        else
            return num * 3;
    });
    return ans;
}