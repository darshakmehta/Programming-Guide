import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public long getMaxAmount(HashMap<Long, Long> hmap, long n) {
		if(hmap.containsKey(n))
			return hmap.get(n);
		if(n == 0 || n == 1) {
			hmap.put(n, n);
			return n;
		}
		
		long x = Math.max(n, getMaxAmount(hmap, n/2) + getMaxAmount(hmap, n/3) + getMaxAmount(hmap, n/4));
		//System.out.println(n + " " + x);
		hmap.put(n,x);
		
		return x;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		HashMap<Long, Long> hmap = new HashMap<Long, Long>();
		Solution s = new Solution();
		
		while(sc.hasNext()) {
			long x = sc.nextLong();
			if(hmap.containsKey(x)) {
				System.out.println(hmap.get(x));
			} else {
				System.out.println(s.getMaxAmount(hmap, x));
			}
		}
	}
}


/***

Since we have to find the solution of state(n/2), state(n/3), state(n/4) we can think like DP, and memoized the results.
How to choose between Tabulation vs Memoization?
Answer: Since we do not have to explore all the states to find the maxAmount for a given n; we will used memoization and explored only the states which are needed to compute the final results.


***/