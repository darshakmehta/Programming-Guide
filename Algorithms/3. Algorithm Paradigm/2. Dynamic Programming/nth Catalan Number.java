import java.lang.*;
import java.io.*;
import java.util.*;

class NthCatalanNumber { //O(n^2)


	public static long nthCatalanNumber (int n) {
		long catalan[] = new long[n + 1];

		catalan[0] = 1; catalan[1] = 1; //base case
		for(int i = 2; i <= n; i++) {
			for(int j = 0; j < i; j++) {
				catalan[i] += catalan[j] * catalan[i - j - 1];
			}
		}

		return catalan[n];
	}

	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);

		int n = 35;
		System.out.println(nthCatalanNumber(n));
	}
}

class NthCatalanNumberBinomial { //O(n)

	public static long binomialCoefficient(long n, long k) {
		long result = 1;

		//Since C(n, k) = C(n, n - k)
		if( k > n - k)
			k = n - k;

		for(int i = 0; i < k; i++) {
			result *= (n - i);
			result /= (i + 1);
		}
		return result;
	}

	public static long nthCatalanNumber (int n) {
		long c = binomialCoefficient(2 * n, n);
		return c / ( n + 1);
	}

	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);

		int n = 30;
		System.out.println(nthCatalanNumber(n));
	}
}

/***

1. Recursive solution recomputes catalan values, running time is O(2 ^ n)

2. DP solution, memoizes the catalan for subproblem, running time is O(n ^ 2)
Maximum n = 35, after that it overflows, use BigInteger to calculate for very large catalan numbers

3. Binomial Coefficient formula, we can get the nth Catalan number in O(n) time
Maximum n = 30, after that it overflows
Referencce: https://www.geeksforgeeks.org/program-nth-catalan-number/
We have 2 different style of binomial formulas


***/

/***

Application of Catalan Numbers: [Reference: https://www.geeksforgeeks.org/applications-of-catalan-numbers/]

1. Number of possible binary search Trees with n keys
2. Number of expression containing n pair of parentheses.
3. Number of ways polygon of n + 2 sides, can be split into triangle without crossing diagonals of each other
4. Number of full binary trees with n + 1 leaves.
5. Handshake Problem
6. ... 

***/