import java.util.*;
import java.lang.*;
import java.io.*;

class CheckPermutation { //O(n log n) Sorting time
	
	boolean checkPermutation(String s1, String s2) {
		char a[] = s1.toCharArray();
		char b[] = s2.toCharArray();
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		return Arrays.equals(a,b);
	}

	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		CheckPermutation cp = new CheckPermutation();
		if(a.length() == b.length())  //if length is different return false
			System.out.println(cp.checkPermutation(a,b));
		else 
			System.out.println("false");
	}
}


class CheckPermutation { //HashMap Implementation, count occurences of first string and store, check for another string if we have any key with more than 0 return false.  //O(n) time
	
	boolean checkPermutation(String s1, String s2) { //O(len(a) + len(b))
		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
		char[] a = s1.toCharArray();
		char[] b = s2.toCharArray();
		int x, k;

		for(int i = 0; i < a.length; i++) {
			int count = 1;
			
			if(hmap.containsKey(a[i])) {
				count = hmap.get(a[i]);
				count++;
			}
			hmap.put(a[i], count);	
		}

		for(int i = 0; i < b.length; i++) {
			
			if(hmap.containsKey(b[i])) {
				if(hmap.get(b[i]) == 0)
					return false;
				else {
					k = hmap.get(b[i]);
					k--;
					hmap.put(b[i],k);
				}
				
			}
		}
		/*Set set = hmap.entrySet(); //Not required as you will have encountered failure in early stage only. Since different length string is checked in main function.
		Iterator iter = set.iterator();
		 while (iter.hasNext()) {
		        Map.Entry entry = (Map.Entry) iter.next();
		        Integer value = (Integer)entry.getValue();
		        if(value != 0)
			return false;
		   
		}*/
		return true;
	}
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		CheckPermutation cp = new CheckPermutation();
		if(a.length() == b.length())  //if length is different return false
			System.out.println(cp.checkPermutation(a,b));
		else 
			System.out.println("false");
	}
}

class CheckPermutation { //Using Extra Array space, to computer the occurences of characters in both the strings
	
	boolean checkPermutation(String s1, String s2) { //O(len(a) + len(b))
		int arr[] = new int[128];
		char a[] = s1.toCharArray();
		char b[] = s2.toCharArray();
		for(int i = 0; i < a.length; i++) {
			arr[(int)a[i]]++;
		}
		for(int i = 0; i < b.length; i++) {
			if(arr[(int)b[i]] == 0) {
				return false;
			}
			arr[(int)b[i]]--;
		}
		/*for( int i = 0; i < 128; i++) { //Not required as you will have encountered failure in early stage only. Since different length string is checked in main function.
			if(arr[i] != 0)
				return false;
		}*/
		return true;
	}
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		CheckPermutation cp = new CheckPermutation();
		if(a.length() == b.length())  //if length is different return false
			System.out.println(cp.checkPermutation(a,b));
		else 
			System.out.println("false");
	}
}