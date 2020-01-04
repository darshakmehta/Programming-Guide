import java.util.*;
import java.lang.*;
import java.io.*;

class FibonacciNumber
{

	public static long nthfibonacciNumber(int n) {
		long dp[] = new long[n];
		dp[0] = 1; dp[1] = 1; //base case

		for(int i = 2; i < n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n - 1];
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = 92;
		System.out.println(nthfibonacciNumber(n));
	}
}

class FibonacciNumberSpaceOptimized //Running time is O(n) Extra space is O(1)
{

	public static long nthfibonacciNumberSpace(int n) {
		long a = 0;
		long b = 1;
		long c = -1;
		for(int i = 2; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = 92;
		System.out.println(nthfibonacciNumberSpace(n));
	}
}

class NthFibonacciOfLargeNumber
{

	public static BigInteger nthfibonacciNumber(int n) {
		BigInteger a = BigInteger.valueOf(0);
		BigInteger b = BigInteger.valueOf(1);
		BigInteger c = BigInteger.valueOf(1);

		for(int i = 2; i <= n; i++) {
			c = a.add(b);
			a = b;
			b = c;
		}
		return c;
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = 1000;
		System.out.println(nthfibonacciNumber(n));
	}
}

/***

Recursion solution is exponential, therefore we will memoized as we move ahead.
Above solution is tabulated version of fibonacciNumebrs where running time is O(n) and extra space of O(n)


TODO:
1. Since we do not want to access the values of {i - 1, i - 2}; once we have passed ahead, so we can just not store them [Completed]
2. Implement using Using power of the matrix {{1,1},{1,0}} and also its optimized version {O(log n) and O(log n) for recursive stack else O(1)}
3. Implement using recurrence formula in O(log n) time
4. Implement using BigInteger (from class math of java) in Java for large numbers [Completed as class NthFibonacciOfLargeNumber]
5. Using golden ratio, but it is not used practically. Since it is floating point number, we lost bits in calculation.
Reference: https://www.geeksforgeeks.org/g-fact-18-2/

Note: Maximum: n = 92; later it will overflow, for class FibonacciNumber

***/