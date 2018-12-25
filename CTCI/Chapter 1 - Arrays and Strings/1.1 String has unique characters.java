import java.util.*;
import java.lang.*;
import java.io.*;

class IsUnique {  //Brute Force: O(n^2) and O(1) space
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		boolean flag = true;
		int count = 0;
		for( int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length() - 1; j++) {
				count++;
				if(s.charAt(i) == s.charAt(j)) {
					flag = false;
					break;
				}
			}
			if(!flag)
				break;
		}
		System.out.println("Looped " + count + " times ");
		if(flag)
			System.out.println("It is unique");
		else
			System.out.println("It is not unique");
	}	
}

class IsUnique { //HashMap: O(n)
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		boolean flag = true;
		int count = 0;
		
		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
		
		for( char c : s.toCharArray() ) {
			count++;
			if(!hmap.containsKey(c)) {
				hmap.put(c, 1);
			} else {
				flag = false;
				break;
			}
		}

		System.out.println("Looped " + count + " times ");
		if(flag)
			System.out.println("It is unique");
		else
			System.out.println("It is not unique");
	}
}

class IsUnique { //HashSet: O(n)
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		boolean flag = true;
		int count = 0;
		
		Set<Character> set = new HashSet<Character>();
		
		for(char c : s.toCharArray()) {
			count++;
			if(!set.contains(c)) {
				set.add(c);
			} else {
				flag = false;
				break;
			}
		}
		
		System.out.println("Looped " + count + " times ");
		if(flag)
			System.out.println("It is unique");
		else
			System.out.println("It is not unique");

	}
}

//Note: If we use faster sort and do in O(n log n) time. But make a note of extra space usage
class IsUnique { //Insertion String Sort: O(n^2) and linear time to find if there is duplicate character
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char[] c = s.toCharArray();
		boolean flag = true;
		int j;
		//Sorting string
		for( int i = 1; i < c.length; i++) {
			char temp = c[i];
			for(j = i; j > 0; j--) {
				if(temp > c[j-1]) {
					break;
				} else {
					c[j] = c[j-1];
				}
			}
			c[j] = temp;
		}
		//String sb = String.valueOf(c);
		for(int i = 0; i < c.length - 1; i++) {
			if(c[i] == c[i+1]) {
				flag = false;
				break;
			}
		}		
		System.out.println(flag);
	}
}

class IsUnique { //Using temporary array of size 128 alphabets, check for duplicates with boolean array. Note if len(string) greater than 128 return false
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		boolean b[] = new boolean[128];
		boolean flag = true;
		
		if(s.length() > 128) {
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if(b[(int)c] != true) {
					b[(int)c] = true;
				} else {
					flag = false;
					break;
				}
			}
		} else {
			flag = false;
		}
		
		System.out.println(flag);

	}
}

/*** TODO: Solution using Bit vector ***/

/**

Takeaways

1. If string is greater than 128 characters or 256 whichever in consideration check if/else

**/
