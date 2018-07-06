import java.util.*;
import java.lang.*;
import java.io.*;

class MaxNumber
{
	/* Flips a 1 to a 0 and a 0 to a 1  */
	public int flip(int bit) {
		return 1 ^ bit;
	}
	/* Returns 1 if c is positive, and 0 if a is negative */
	public int sign(int c) {
		return flip((c >> 31) & 0x1);
	}

	public int getMaxNumber(int a, int b) {
		int k = sign(a - b); //overflows
		int q = flip(k);
		return a * k + b * q;
	}

	public int getMax(int a, int b) {
		int c = a - b;

		int sa = sign(a); // if a >=0, then 1 else 0
		int sb = sign(b); // if b >=0, then 1 else 0
		int sc = sign(c); // depends on whether or not a - b overflows
		//System.out.println(sa + " " + sb + " " + sc);
		int use_sign_of_a = sa ^ sb; // if a and b have different signs, then k = sign(a)
		int use_sign_of_c = flip(sa ^ sb); // if a and b have same sign, then k = sign(a - b)
		//System.out.println(use_sign_of_a + " " + use_sign_of_c);
		int k = use_sign_of_a * sa + use_sign_of_c * sc;
		int q = flip(k); // opposite of k
		//System.out.println(k + " " + q);
		return a * k + b * q;

	}

	public static void main (String[] args) throws java.lang.Exception
	{
		MaxNumber mn = new MaxNumber();
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		//System.out.println(mn.getMaxNumber(a, b)); //overflows
		System.out.println(mn.getMax(a, b)); //works well


	}
}



/***

Solution 1 [getMaxNumber] overflows at a - b
Solution 2 [getMax] works well

***/