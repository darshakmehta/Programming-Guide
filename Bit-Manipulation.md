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







References:

1. https://leetcode.com/problems/sum-of-two-integers/discuss/84290/Java-simple-easy-understand-solution-with-explanation
2. https://leetcode.com/problems/sum-of-two-integers/discuss/84278/A-summary:-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently