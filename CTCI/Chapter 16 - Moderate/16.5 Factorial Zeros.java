import java.util.*;
import java.lang.*;
import java.io.*;

class TrailingZeroesFactorial //Using Polignac's Formula
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int answer = 0;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if( n < 0)
			return;

		/*
		int i = 0;
		This is just counting 5 multiples less than n, faster way is to divide n by 5
		while(!(Math.pow(5,i) > n)) 
			i++;
		*/

		/*
		
		int multiplesOfFive = n / 5;
		for(int j = 1; j < multiplesOfFive; j++) 
			answer += (n / Math.pow(5,j));

		*/

		//Optimized for loop

		for(int i = 5; n / i > 0; i *=5) {
			answer += (n / i);
		}

		System.out.println(answer);
	}
}