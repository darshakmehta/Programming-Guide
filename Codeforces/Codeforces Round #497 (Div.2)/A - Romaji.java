import java.util.*;
import java.lang.*;
import java.io.*;

public final class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		char []c = s.toCharArray();
		int n = c.length;
		if(!(c[n - 1] == 'a' || c[n - 1] == 'e' || c[n - 1] == 'i' || c[n - 1] == 'o' || c[n - 1] == 'u' || c[n - 1] == 'n')) {
			System.out.println("NO");
			return;
		}
		boolean flag = true;
		for(int i = 0; i < c.length - 1; i++) {
			if(!(c[i] == 'a' || c[i] == 'e' || c[i] == 'i' || c[i] =='o' || c[i] == 'u' || c[i] == 'n')) {
				if((c[i + 1] =='a' || c[i+1] == 'e' || c[i+1] == 'i' || c[i+1] == 'o' || c[i+1] == 'u')) {
					continue;
				} else {
					flag = false;
					break;
				}
			}
		}
		if(flag)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}