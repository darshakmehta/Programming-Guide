import java.util.*;
import java.lang.*;
import java.io.*;

class UglyNumbers
{

	public static int findNthUglyNumber(int n) {
		int ugly[] = new int[n];
		int i2 = 0, i3 = 0, i5 = 0;
		int next_multiple_of_2 = 2;
		int next_multiple_of_3 = 3;
		int next_multiple_of_5 = 5;
		int next_ugly_no = 1;
		ugly[0] = next_ugly_no;

		for(int i = 1; i < n; i++) {
			next_ugly_no = Math.min(next_multiple_of_2, Math.min(next_multiple_of_3, next_multiple_of_5));
			ugly[i] = next_ugly_no;

			if(next_ugly_no == next_multiple_of_2) {
				i2++;
				next_multiple_of_2 = ugly[i2] * 2;
			}
			if(next_ugly_no == next_multiple_of_3) {
				i3++;
				next_multiple_of_3 = ugly[i3] * 3;
			}
			if(next_ugly_no == next_multiple_of_5) {
				i5++;
				next_multiple_of_5 = ugly[i5] * 5;
			}
		}
		return next_ugly_no;
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = 150;
		System.out.println(findNthUglyNumber(n));
	}
}

/***

Looping until we reach to the nth ugly number is not efficient, as we have to check all the numbers. Space is O(1)
Using DP tabulation method we can reach faster to the goal state with running time of O(n). Space is O(n)

***/


