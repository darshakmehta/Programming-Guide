import java.util.*;
import java.lang.*;
import java.io.*;

class URLify // Not a good approach. Extra space
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int len = sc.nextInt();
		char a[] = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < len; i++) {
			if(a[i] == ' ') {
				sb.append("%20");
			} else {
				sb.append(a[i]);
			}
		}
		System.out.println(sb.toString());
	}
}


class URLify
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int len = sc.nextInt();
		char a[] = s.toCharArray();
		int spaceCount = 0;

		for(int i = 0; i < len; i++) {
			if(a[i] == ' ')
				spaceCount++;
		}
		
		int index = len + spaceCount * 2;
		
		if(len < a.length) 
			a[len] = '\0'; 
		
		for(int i = len - 1; i >= 0; i--) {
			if(a[i] == ' ') {
				a[index-1]='0';
				a[index-2]='2';
				a[index-3]='%';
				index = index - 3;
			} else {
				a[index-1] = a[i];
				index--;
			}
		}
		System.out.println(String.valueOf(a) + " " + a.length);
		
	}
}


/***

Input: 
Mr John Smith    
13

Output:

Mr%20John%20Smith 17

***/