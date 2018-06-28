import java.util.*;
import java.lang.*;
import java.io.*;

class OneAway //Linear time O(n) where n = length of largest string
{
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
			int numberOfOdds = 0;
			if(c1.length > c2.length) {
				int j = 0;
				for(int i = 0; i < c1.length; i++) {
					if(c1[i] != c2[j])
						numberOfOdds++;
					else {
						j++;
						if(j == c2.length)
						    break;
					}
				}
				if(numberOfOdds > 1)
					flag = false;
				else 
					flag = true;
			} else if(c1.length == c2.length) {
				for(int i = 0; i < c1.length; i++) {
					if(c1[i] != c2[i]) 
						numberOfOdds++;
				}
				if(numberOfOdds > 1)
					flag = false;
				else
					flag = true;
			} else {
				int k = 0;
				for(int i = 0; i < c2.length; i++) {
					if(c1[k] != c2[i])
						numberOfOdds++;
					else {
						k++;
						if(k == c1.length)
						    break;
					}
				}
				if(numberOfOdds > 1)
					flag = false;
				else
					flag = true;
			}
			System.out.println(flag);
		}
	}
}

/***

TODO: 1. Merge insert and remove in one pass 2. Merge all into one pass

***/