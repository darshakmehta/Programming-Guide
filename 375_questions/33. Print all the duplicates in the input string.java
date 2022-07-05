import java.util.*;
import java.lang.*;
import java.io.*;

class Solution { // Inefficient when string values contain less variety of characters
	public static void getDuplicatesWithCount(String s) {
		final int NO_OF_CHARS = 256;
		int[] count = new int[NO_OF_CHARS];
		char[] arr = s.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}

		for (int i = 0; i < NO_OF_CHARS; i++) {
			if (count[i] > 1) {
				System.out.println("Character: " + (char)(i) + " is duplicated " + count[i] + " times");
			}
		}

	}

	public static void main (String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();

		getDuplicatesWithCount(s);
	}
}

/**
Ideone: https://ideone.com/PmcRjK
**/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution { // Space Efficient
	public static void getDuplicatesWithCount(String s) {
		char[] arr = s.toCharArray();
		Map<Character, Integer> hmap = new HashMap<Character, Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (!hmap.containsKey(arr[i])) {
				hmap.put(arr[i], 1);
			} else {
				hmap.put(arr[i], hmap.get(arr[i]) + 1);
			}
		}

		Set set = hmap.entrySet();
	    Iterator iter = set.iterator();
	    while (iter.hasNext()) {
	      Map.Entry pair = (Map.Entry) iter.next();
			if ((Integer) pair.getValue() > 1) {
				System.out.println("Character: " + (char)(pair.getKey()) + " is duplicated " + pair.getValue() + " times");
			}
		}

	}

	public static void main (String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();

		getDuplicatesWithCount(s);
	}
}

/**
Ideone: https://ideone.com/ZMMX4Y
**/
