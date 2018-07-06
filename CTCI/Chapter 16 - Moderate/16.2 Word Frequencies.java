import java.util.*;
import java.lang.*;
import java.io.*;

class WordFrequency
{
	public void createDictionary(HashMap<String, Integer> hmap, String arr[]) {
		
		for(String word : arr) {
			word = word.toLowerCase();
			if(word.trim() != "") {
				if(!hmap.containsKey(word)) {
					hmap.put(word, 0);	
				}
				hmap.put(word, hmap.get(word) + 1);
			}
			
		}
	}
	
	public int getFrequency(HashMap<String, Integer> hmap, String key) {
		if(hmap == null || key == null)
			return -1;
		String word = key.toLowerCase();
		
		if(hmap.containsKey(word)) {
			return hmap.get(word);
		}
		return 0;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		WordFrequency wf = new WordFrequency();
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String arr[] = s.split(" ");
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		wf.createDictionary(hmap, arr);
		
		System.out.println(wf.getFrequency(hmap, "tHis"));
	}
}


/***

Problem a: Find a word how frequently present in a book? 
Solution: Traverse all the words in the book and find out the frequency, i.e O(n)

Problem b: If algorithm is repeatedly used to check words?
Solution: Use extra time and memory to setup the HashMap as above, and we can have O(1) lookup for the key to getFrequency in the book.


***/