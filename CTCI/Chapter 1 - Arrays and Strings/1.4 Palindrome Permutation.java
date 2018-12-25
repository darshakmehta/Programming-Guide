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
			if(a[i] <='z' && a[i] >= 'A') {
				len++;
				int count = 1;
				if(hmap.containsKey(a[i])) {
					count = hmap.get(a[i]);
					count++;
				}
				hmap.put(a[i], count);
				
				if(count % 2 == 0) {
					countOdd--;
				} else {
					countOdd++;
				}	
			}
		}

		String inputType = "";
		if(len % 2 == 0) 
			inputType = "even";
		else
			inputType = "odd";

		if(countOdd == 1 && inputType == "odd") {
			System.out.println("true");
		} else if(countOdd == 0 && inputType == "even")
			System.out.println("true");
		else
			System.out.println("false");
	}
}

/*** TODO: Solution using Bit vector ***/