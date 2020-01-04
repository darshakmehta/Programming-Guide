import java.util.*;
import java.lang.*;
import java.io.*;

class StringSort {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char[] c = s.toCharArray();

		int j;
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
		/*for(int i = 0; i < c.length; i++) {
			System.out.print(c[i]);
		}*/
		String sb = String.valueOf(c);
		System.out.print(sb);

	}
}