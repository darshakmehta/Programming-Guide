import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();


		//Iterate HashMap
		Set set = hmap.entrySet();
		Iterator iter = set.iterator();
		while(iter.hasNext()) {
			Map.Entry pair = (Map.Entry) iter.next();
			System.out.println(pair.getKey() + " " + pair.getValue());  
			/* You need to typecast to use
			For example: int x = (Integer) pair.getValue();*/
		}
	}
}

