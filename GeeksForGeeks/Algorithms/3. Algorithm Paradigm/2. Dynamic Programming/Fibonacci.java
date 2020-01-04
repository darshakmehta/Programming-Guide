import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class Fibonacci
{
	public int fibonacciRecursive(int n) { //exponential running time
		int sum = 0;
		if(n ==  0 || n == 1)
			return n;
		else {
			
			sum+= fibonacciRecursive(n-1) + fibonacciRecursive(n-2);	
		}
		return sum;
			
	}
	
	public int fibonacci(int n) { //O(n) running time using DP
		int a[] = new int[n+1];
		a[0] = 0;
		a[1] = 1;
		int sum = 0;
		for(int i = 2; i<=n; i++) {
			a[i] = a[i-1] + a[i-2];
		}
		return a[n];
	}

	public BigInteger fibonacciSpaceOptimized(int n) { //O(n) running time using DP
		BigInteger a = BigInteger.valueOf(0);
		BigInteger b = BigInteger.valueOf(1);
		BigInteger c = BigInteger.valueOf(0);
		for(int i = 2; i<=n; i++) {
			c = a.add(b);
			a = b;
			b = c;
		}
		return c;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Fibonacci fib = new Fibonacci();
		System.out.println(fib.fibonacciRecursive(6));
		System.out.println(fib.fibonacci(6));
		System.out.println(fib.fibonacciSpaceOptimized(166));

	}
}