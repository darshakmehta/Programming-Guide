import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{

	static class HashMapList<T, E> {
		private HashMap<T, ArrayList<E>> map = new HashMap<T, ArrayList<E>>();

		/* Insert item into list as key */
		public void put(T key, E item) {
			if(!map.containsKey(key)) {
				map.put(key, new ArrayList<E>());
			}
			map.get(key).add(item);
		}

		/* Insert list of items at key */
		public void put(T key, ArrayList<E> items) {
			map.put(key, items);
		}

		/* Get list of items at key */
		public ArrayList<E> get(T key) {
			return map.get(key);
		}

		/* Check if hashmaplist contains key */
		public boolean containsKey(T key) {
			return map.containsKey(key);
		}

		/* Check if list at key contains value */
		public boolean containsKeyValue(T key, E value) {
			ArrayList<E> list = get(key);
			if(list == null) return false;
			return list.contains(value);
		}

		/* Get the list of keys */
		public Set<T> keySet() {
			return map.keySet();
		}

		@Override
		public String toString() {
			return map.toString();
		}

	}

	public static String sortChars(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	
	public static void sort(String []array) {
		HashMapList<String, String> hmap = new HashMapList<String, String>();
		
		/* Group words by Anagram */
		for(String s : array) {
			String key = sortChars(s);
			hmap.put(key, s);
			//System.out.println(key + " " + s);
		}
		
		/* Convert hash table to array */
		int index = 0;
		for(String key : hmap.keySet()) {
			ArrayList<String> list = hmap.get(key);
			for(String t : list) {
				array[index++] = t;
			}
		}
 		
		
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		String arr[] = new String[10];
		for(int i = 0; i < 10; i++) {
			arr[i] = sc.nextLine();
		}
		
		sort(arr);
		for(int i = 0; i < 10; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}



/***

HashMapList< String, Integer> is a HashMap that maps from Strings to ArrayList< Integer>
Implemented HashMapList Class

care
qwerty
eacr
thgryt
asd
race
ytrewq
thgrty
lopl
poll


***/