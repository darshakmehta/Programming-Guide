import java.util.*;
import java.lang.*;
import java.io.*;

class RodCutting
{
	int count; //count number of recursive calls [2^x] where x = number of length of rod considered
	int countTopDownMemoized; 
	int recursiveCountTopDownMemoized;
	int countBottomUp; //Total loops = sum of 1 to n
	public int recursiveTopDownRodCut(int p[], int n) { //exponential running time
		count++;
		if(n == 0)
			return n;
		int q = Integer.MIN_VALUE;
		for(int i = 1; i<=n ;i++)
			q = Math.max(q, p[i] + recursiveTopDownRodCut(p, n-i));
		return q;
	}
	
	public int topDownMemoizedAux(int p[], int n, int r[]) {
		recursiveCountTopDownMemoized++; //number of recursive calls
		int q;
		if(r[n] >= 0)
			return r[n];
		countTopDownMemoized++; //number of times we actually calculate (always n + 1)
		//i.e. to calculate for n (it has to computer n+1 values ranging from 0, ... ,n)
		if(n == 0)
			q = 0;
		else
			q = Integer.MIN_VALUE;
		for(int i = 1; i<=n; i++)
			q = Math.max(q, p[i] + topDownMemoizedAux(p, n-i, r));
		r[n] = q;
		return q;
	}
	
	public int recursiveTopDownMemoizedRodCut(int p[], int n) {
		int r[] = new int[n+1];
		for(int i = 0; i<=n; i++) 
			r[i] = Integer.MIN_VALUE;
			
		return topDownMemoizedAux(p, n, r);
	}
	
	public int bottomUpMemoizedRodCut(int p[], int n) { //n(n+1) /2 ==> O(n^2)
		int r[] = new int[n+1];
		r[0] = 0;
		int q;
		for(int j = 1; j<=n; j++) {
			q = Integer.MIN_VALUE;
			
			for(int i=1; i<=j; i++) {
				countBottomUp++;
				q = Math.max(q, p[i] + r[j-i]);
			}
			r[j] = q;
		}
		
		return r[n];
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int p[] = new int[n+1];
		p[0] = 0; //price is zero for lenth zero
		for(int i = 1; i<=n; i++)
			p[i] = sc.nextInt();
		int x = sc.nextInt(); // input length of rod to be cut
		RodCutting rc = new RodCutting();
		
		System.out.println("Naive Solution");
		System.out.println("Revenue: " + rc.recursiveTopDownRodCut(p,x));
		System.out.println("Total recursive calls: " + rc.count); //2^x (in general formula)
		
		System.out.println();
		System.out.println("Top Down Recursive Memoization");
		System.out.println("Revenue: " + rc.recursiveTopDownMemoizedRodCut(p,x));
		System.out.println("Total recursive calls: " + rc.recursiveCountTopDownMemoized);
		System.out.println("Total calls to actually compute: " + rc.countTopDownMemoized);
		
		System.out.println();
		System.out.println("Bottom Up Memoization");
		System.out.println("Revenue: " + rc.bottomUpMemoizedRodCut(p,x));
		System.out.println("Total loops: " + rc.countBottomUp);
	}
}