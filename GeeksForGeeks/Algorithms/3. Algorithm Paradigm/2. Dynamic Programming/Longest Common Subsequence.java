import java.util.*;
import java.lang.*;
import java.io.*;

class LongestCommonSubsequence
{
	int lcsRecursiveCalls;
	int lcsRecursiveCallsWithMemoization; //at most 2 * n * m callls
	
	public int lcs(String p, String q, int n, int m) { //exponential time
		lcsRecursiveCalls++;
		int result;
		if(n == 0 || m == 0)
			result = 0;
		else if(p.charAt(n-1) == q.charAt(m-1)) 
			result = 1 + lcs(p,q,n-1,m-1);
		else 
			result = Math.max(lcs(p,q,n-1,m),lcs(p,q,n,m-1));
		return result;
	}
	
	public int lcsRecursiveWithMemoization(String p, String q, int n, int m, int c[][]) {
		lcsRecursiveCallsWithMemoization++;
		int result;
		
		if(c[n][m] >= 0)
			return c[n][m];
		if(n == 0 || m == 0)
			result = 0;
		else if(p.charAt(n-1) == q.charAt(m-1)) 
			result = 1 + lcsRecursiveWithMemoization(p,q,n-1,m-1, c);
		else { 
			result = Math.max(lcsRecursiveWithMemoization(p,q,n-1,m, c),lcsRecursiveWithMemoization(p,q,n,m-1, c));
			c[n][m] = result;
		}
		return result;
	}
	
	public int lcsBottomUp(String p, String q, int n, int m, int c[][]) {
		for(int i = 1; i < n; i++)
			c[i][0] = 0;
		for(int i = 0; i < m; i++)
			c[0][i] = 0;
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=m; j++) {
				if(p.charAt(i-1) == q.charAt(j-1)) {
					c[i][j] = 1 + c[i-1][j-1];
				}
				else {
					c[i][j] = Math.max(c[i-1][j], c[i][j-1]);
				}
			}
		}
		//Print solution array
		for(int i = 0; i<=n; i++) {
			for(int j = 0; j<=m; j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
		return c[n][m];
	}
	
	public void printBottomUpSolution(String p, String q, int n, int m, int c[][]) {
		int index = c[n][m];
		int temp = index;
		char ans[] = new char[index+1];
		ans[index] = '\0'; // Set the terminating character
		int i = n;
		int j = m;
		while(i>0 && j>0){
			if(p.charAt(i-1) == q.charAt(j-1)) {
				ans[index-1] = p.charAt(i-1);
				i--;
				j--;
				index--;
			}
			else if(c[i-1][j] > c[i][j-1])
			i--;
			else
			j--;
		
		}
		 // Print the lcs
		
		System.out.print("LCS of "+p+" and "+q+" is ");
		for(int k=0;k<=temp;k++)
			System.out.print(ans[k]);
	}

	public int lcsBottomUpSpaceOptimized(String x, String y) { //Running time is O(m * n) and Space time is O(n)
		int m = x.length();
		int n = y.length();

		int dp[][] = new int[2][n + 1];

		// Binary index, used to index 
        // current row and previous row.
		int bi = 0;

		for(int i = 0; i <= m; i++) {
			bi = i & 1;
			for(int j = 0; j <= n; j++) {
				System.out.println(i + " " + j + " bi: " + bi); //Print index i,j and current row index in dp table
				if( i == 0 || j == 0)
					dp[bi][j] = 0;
				
				else if(x.charAt(i - 1) == y.charAt(j - 1))
					dp[bi][j] = 1 + dp[1 - bi][j - 1];
				else
					dp[bi][j] = Math.max(dp[1 - bi][j], dp[bi][j - 1]);
					
				/* Print DP table */
				for(int p = 0; p < 2; p++) {
					for(int o = 0; o <= n; o++) {
						System.out.print(dp[p][o] + " ");
					}
					System.out.println();
					
				}
			}
		}
		return dp[bi][n];
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		String p = sc.next();
		String q = sc.next();
		int c[][] = new int[p.length() + 1][q.length() + 1];
		LongestCommonSubsequence LCS = new LongestCommonSubsequence();
		
		System.out.println("Recursive solution");
		System.out.println("Length of common subsequence is: " + LCS.lcs(p,q,p.length(),q.length()));
		System.out.println("Total recursive Calls: " + LCS.lcsRecursiveCalls);
		
		//initialize to lower value
		for(int i = 0; i<p.length() + 1; i++) {
			for(int j = 0;j<q.length() + 1;j++) {
				c[i][j] = Integer.MIN_VALUE;
			}
		}
		
		System.out.println("Recursive solution with memoizataion");
		System.out.println("Length of common subsequence is: " + LCS.lcsRecursiveWithMemoization(p,q,p.length(),q.length(),c));
		System.out.println("Total recursive Calls: " + LCS.lcsRecursiveCallsWithMemoization);
		
		//initialize to lower value
		for(int i = 0; i<p.length() + 1; i++) {
			for(int j = 0;j<q.length() + 1;j++) {
				c[i][j] = 0;
			}
		}
		
		System.out.println("Bottom Up Solution");
		System.out.println("Length of common subsequence is: " + LCS.lcsBottomUp(p,q,p.length(),q.length(),c));
		LCS.printBottomUpSolution(p,q,p.length(),q.length(),c);

		System.out.println();
		System.out.println("Bottom Up Solution Space Optimized");
		System.out.println("Length of common subsequence is: " + LCS.lcsBottomUpSpaceOptimized(p,q));
	}
}