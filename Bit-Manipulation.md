# Bit-Manipulation

"&" AND operation, for example, 2 (0010) & 7 (0111) => 2 (0010) [both 1's --> 1]

"^" XOR operation, for example, 2 (0010) ^ 7 (0111) => 5 (0101) [Both same --> 0, else 1]

"~" NOT operation, for example, ~2(0010) => -3 (1101) [Two's complement]

Q. To get a Negative Number?
A. 

	public int negate(int x) {
		return ~x + 1; // 2's complement
	}

Q. Sum of Two Integers (a,b) using Bit Manipulation
A. 

	To find Carry => a & b
	To find different bit => a ^ b
	To shift one position left => 1

	Algorithm:
	1. Find Carry using AND operation
	2. Find the different bits and store in first number using XOR operation
	3. Left shift Carry bit by 1 and store as second number using << Operation
	4. Continue until no carry (i.e. carry != 0) or second number != 0

Code:

	// Iterative
	public int getSum(int a, int b) {
		while(b != 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		return a;
	}

	// Recursive
	public int getSum(int a, int b) {
		return (b == 0) ? a : getSum(a ^ b, (a & b) << 1);
	}

Q. Difference of Two Integers (a,b) using Bit Manipulation
A. 

	To find Borrow => (~a) & b
	To find different bit => a ^ b
	To shift one position left => 1

	Algorithm:
	1. Find Borrow using AND operation with 2's complement of a
	2. Find the different bits and store in first number using XOR operation
	3. Left shift Borrow bit by 1 and store as second number using << Operation
	4. Continue until no borrow (i.e. borrow != 0) or second number != 0

Code:

	// Iterative
	public int getSum(int a, int b) {
		while(b != 0) {
			int borrow = (~a) & b;
			a = a ^ b;
			b = borrow << 1;
		}
		return a;
	}

	// Recursive
	public int getSubtract(int a, int b) {
		return (b == 0) ? a : getSubtract(a ^ b, (~a & b) << 1);
	}

Q. Find the only repetitive element between 1 to n-1 [3]
A.

Examples :

	Input  : a[] = {1, 3, 2, 3, 4}
	Output : 3

	Input  : a[] = {1, 5, 1, 2, 3, 4}
	Output : 1

The idea is based on the fact that x ^ x = 0 and x ^ y = y ^ x.

1. Compute XOR of elements from 1 to n-1.
2. Compute XOR of array elements.
3. XOR of above two would be our result.

Code:

	static int findRepeating(int arr[], int n) { 
        // res is going to store value of 
        // 1 ^ 2 ^ 3 .. ^ (n-1) ^ arr[0] ^  
        // arr[1] ^ .... arr[n-1] 
        int res = 0; 
        for (int i = 0; i < n - 1; i++) 
            res = res ^ (i + 1) ^ arr[i]; 
        res = res ^ arr[n - 1]; 
              
        return res; 
    }


References:

1. https://leetcode.com/problems/sum-of-two-integers/discuss/84290/Java-simple-easy-understand-solution-with-explanation
2. https://leetcode.com/problems/sum-of-two-integers/discuss/84278/A-summary:-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently
3. https://www.geeksforgeeks.org/find-repetitive-element-1-n-1/