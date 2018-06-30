import java.util.*;
import java.lang.*;
import java.io.*;

class PalindromePermutation //O(n)
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
		String s = sc.nextLine();
		char a[] = s.toCharArray();
		int countOdd = 0;
		int len = 0;
		for( int i = 0; i < a.length; i++) {
			int count = 1;
			//System.out.println(a[i]);
			if(a[i] <='z' && a[i] >= 'A') {
				len++;
				if(hmap.containsKey(a[i])) {
					count = hmap.get(a[i]);
					count++;
				}
				hmap.put(a[i],count);
				if(count % 2 == 0) {
					countOdd--;
				} else {
					countOdd++;
				}	
			}
		}
		String help;
		if(len % 2 == 0) 
			help = "even";
		else
			help = "odd";
		if(countOdd == 1 && help == "odd") {
			System.out.println("true");
		} else if(countOdd == 0 && help == "even")
			System.out.println("true");
		else
			System.out.println("false");
	}
}

/*** TODO: Solution using Bit vector ***/