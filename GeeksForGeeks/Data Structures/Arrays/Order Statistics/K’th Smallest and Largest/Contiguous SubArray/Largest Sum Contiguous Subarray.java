/***

Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.

Kadane’s Algorithm:

Initialize:
    max_so_far = 0
    max_ending_here = 0

Loop for each element of the array
  (a) max_ending_here = max_ending_here + a[i]
  (b) if(max_ending_here < 0)
            max_ending_here = 0
  (c) if(max_so_far < max_ending_here)
            max_so_far = max_ending_here
return max_so_far

Explanation:
Simple idea of the Kadane’s algorithm is to look for all positive contiguous segments of the array (max_ending_here is used for this). And keep track of maximum sum contiguous segment among all positive segments (max_so_far is used for this). Each time we get a positive sum compare it with max_so_far and update max_so_far if it is greater than max_so_far

**/

/**

Solution:
1. https://git.io/JeN9f [Handle Negative Arrays]
2. https://git.io/fhUPT [Optimized version of Kadane's Algorithm]
3. Use 4th Solution to find the Path using start and end index [Print maximum subarray]
4. https://git.io/JeN7h [Print start and end Index of Subarray]

**/

/**

#TODO:

Given an array of integers (possibly some of the elements negative), write a C program to find out the *maximum product* possible by multiplying ‘n’ consecutive integers in the array where n <= ARRAY_SIZE. Also print the starting point of maximum product subarray.

**/