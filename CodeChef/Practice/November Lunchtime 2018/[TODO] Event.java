import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		Map<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("monday", 1);
		hmap.put("tuesday", 2);
		hmap.put("wednesday", 3);
		hmap.put("thursday", 4);
		hmap.put("friday", 5);
		hmap.put("saturday", 6);
		hmap.put("sunday", 7);
		
		while(t != 0) {
			String S = sc.next();
			String E = sc.next();
			int L = sc.nextInt();
			int R = sc.nextInt();
			
			int difference = Math.abs(hmap.get(S) - hmap.get(E) + 1);
			int modL = L % 7;
			int modR = R % 7;
			
			if(difference >= modL || difference <= modR) {
				System.out.println("")
			}
			
			
			
			
			
			t--;
		}
		
	}
}