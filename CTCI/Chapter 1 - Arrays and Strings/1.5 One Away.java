import java.util.*;
import java.lang.*;
import java.io.*;

class OneAway  //Linear time O(n) where n = length of largest string
{
	public int oneEditReplace(char c1[], char c2[]) {
		int numberOfOdds = 0;
		for(int i = 0; i < c1.length; i++)
			if(c1[i] != c2[i])
				numberOfOdds++;
		return numberOfOdds;
	}
	
	public int oneEditInsertAndRemove(char c1[], char c2[]) {
		int j = 0;
		int numberOfOdds = 0;
		for(int i = 0; i < c1.length; i++) {
			if(c1[i] != c2[j])
				numberOfOdds++;
			else {
				j++;
				if(j == c2.length)
				    break;
			}
		}
		return numberOfOdds;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner  sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		char c1[] = s1.toCharArray();
		char c2[] = s2.toCharArray();
		boolean flag = false;
		if(Math.abs(c1.length - c2.length) > 1) {
			System.out.println(flag);
		} else {
			OneAway oneAway = new OneAway();
			int numberOfOdds = 0;
			if(c1.length == c2.length) {
				numberOfOdds = oneAway.oneEditReplace(c1, c2);	
			} 
			else {
				if(c1.length > c2.length) 
					numberOfOdds = oneAway.oneEditInsertAndRemove(c1, c2);
				else
					numberOfOdds = oneAway.oneEditInsertAndRemove(c2, c1);
			}
			if(numberOfOdds > 1)
			    flag = false;
			else
			    flag = true;
			System.out.println(flag);
		}
	}
}

/***

Completed: 
1. Merge insert and remove in one pass [Completed - by checking the length of string]
2. Merge all into one pass [Completed - It is one pass, either of one will happen]

***/