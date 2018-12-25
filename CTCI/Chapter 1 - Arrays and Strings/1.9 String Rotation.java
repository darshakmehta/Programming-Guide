import java.util.*;
import java.lang.*;
import java.io.*;

class StringRotation //O(n)
{
	public boolean isSubstring(String s1s1, String s2) {
		return s1s1.contains(s2);
	}
	 
	public static void main (String[] args) throws java.lang.Exception
	{
		StringRotation stringRotation = new StringRotation();
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next(); //waterbottle
		String s2 = sc.next(); //Cut at any part and split s1 into x and y and generate y + x
		if(s1.length() == s2.length() && s1.length() > 0) {
			String s1s1 = s1 + s1; // waterbottlewaterbottle
			System.out.println(stringRotation.isSubstring(s1s1, s2));
		} else {
			System.out.println("Strings of different Length");
		}
	}
}