import java.util.*;
import java.lang.*;
import java.io.*;

class StringCompression
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char c[] = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		int count = 1;
		boolean flag;
		
		for( int i = 0; i < c.length - 1; i++) {
			if(c[i] == c[i+1]) {
				count++;
			} else {
				sb.append(c[i] + "" + count);
				count = 1;
			}
		}
		sb.append(c[c.length - 1] + "" + count);
		flag = c.length > sb.length() ? false : true;
		if(flag)
			System.out.println(s);
		else
			System.out.println(sb.toString());
	}
}