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
		String s1 = sc.next();
		String s2 = sc.next();
		int len = s1.length();
		if(len == s2.length() && len > 0) {
			String s1s1 = s1 + s1;
			System.out.println(stringRotation.isSubstring(s1s1, s2));
		}
	}
}