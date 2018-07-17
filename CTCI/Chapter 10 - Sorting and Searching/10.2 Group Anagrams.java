import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	static class AnagramComparator implements Comparator<String> {
		
		public String sortChars(String s) {
			char[] content = s.toCharArray();
			Arrays.sort(content);
			return new String(content);
		}
		
		public int compare(String s1, String s2) {
			return sortChars(s1).compareTo(sortChars(s2));
		}
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		String arr[] = new String[10];
		for(int i = 0; i < 10; i++) {
			arr[i] = sc.nextLine();
		}
		
		Arrays.sort(arr, new AnagramComparator());
		for(int i = 0; i < 10; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}

/***

Above Algorithm using Sorting will take O(n log(n)) time

***/