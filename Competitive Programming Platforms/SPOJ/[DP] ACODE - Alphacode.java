import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String s = sc.nextLine();
			char c[] = s.toCharArray();
			int len = c.length;
			if(c[0] == '0')
				return;
			long dp[] = new long[len];
			dp[0] = 1;
			int x;
			if(len >= 2) {
				x = (c[1] - '0') + (c[0] - '0') * 10;
				if(x<=26 && x>=10)
					dp[1]++;
				if(c[1] != '0')
					dp[1]++;
			}
			for(int i = 2; i < len; i++) {
				x = (c[i] - '0') + (c[i -1] - '0') * 10;	
				if(x<=26 && x>=10)
					dp[i] += dp[i-2];
				if(c[i] != '0')
					dp[i] += dp[i-1];
			}
			System.out.println(dp[len-1]);
		}
}

}


/***

Tip: Here we use tabulation method, because we have to explore all the states atleast, i.e traverse the string once. Running time is O(N) where N = length of string

TODO:

Do not use the extra space storage i.e. DP[]; instead make use of 3 constants a,b,c which stores the prev, current etc.

***/