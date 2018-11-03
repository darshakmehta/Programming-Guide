import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public void init(boolean []max) {
		for(int i = 2; i < max.length; i++) {
			//System.out.println("true");
			max[i] = true;
		}
	}
	
	boolean[] findPrimes(int max) {
		boolean[] flags = new boolean[max + 1];
		int count = 0;
		
		init(flags);
		int prime = 2;
		
		while(prime <= Math.sqrt(max)) {
			crossOff(flags, prime);
			
			prime = getNextPrime(flags, prime);
		}
		
		return flags;
	}
	
	public void crossOff(boolean[] flags, int prime) {
		for(int i = prime * prime; i < flags.length; i += prime) {
			flags[i] = false;
		}
	}
	
	public int getNextPrime(boolean flags[], int prime) {
		int next = prime + 1;
		while(next < flags.length && !flags[next]) {
			next++;
		}
		
		return next;
	}
	
	public boolean checkPalindrome(long x) {
		String s1 = x + "";
		StringBuilder sb = new StringBuilder(s1);
		String s2 = sb.reverse() + "";
		return s1.equals(s2);
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		boolean []primes = new boolean[10000001];
		Solution s = new Solution();
		primes = s.findPrimes(10000001);
		Scanner sc = new Scanner(System.in);
		long x = sc.nextInt();
		while(x < 100000001) {
			x++;
			if(primes[(int)x]) {
				boolean b = s.checkPalindrome(x);
				if(b) {
					break;
				}
			}
		}
		if(!(x > 100000000)) 
			System.out.println(x);
		else
			System.out.println(-1);
		
	}
}



class Solution {
    
    public void init(boolean []max) {
		for(int i = 2; i < max.length; i++) {
			//System.out.println("true");
			max[i] = true;
		}
	}
	
	boolean[] findPrimes(int max) {
		boolean[] flags = new boolean[max + 1];
		int count = 0;
		
		init(flags);
		int prime = 2;
		
		while(prime <= Math.sqrt(max)) {
			crossOff(flags, prime);
			
			prime = getNextPrime(flags, prime);
		}
		
		return flags;
	}
	
	public void crossOff(boolean[] flags, int prime) {
		for(int i = prime * prime; i < flags.length; i += prime) {
			flags[i] = false;
		}
	}
	
	public int getNextPrime(boolean flags[], int prime) {
		int next = prime + 1;
		while(next < flags.length && !flags[next]) {
			next++;
		}
		
		return next;
	}
	
	public boolean checkPalindrome(int x) {
		String s1 = x + "";
		StringBuilder sb = new StringBuilder(s1);
		String s2 = sb.reverse() + "";
		return s1.equals(s2);
	}
	
    
    public int primePalindrome(int N) {
        boolean []primes = new boolean[100000001];
		Solution s = new Solution();
		primes = s.findPrimes(100000001);
		int x = N;
		while(true) {
			
			if(primes[x]) {
				boolean b = s.checkPalindrome(x);
				if(b) {
					break;
				}
			}
            x++;
		}
		return x;
    }
}


/***

TODO:

1. Memory Limit Exceed for initializing 10^8 size boolean array [Write a optimized version of Sieve]
2. Check what to return if the value is N = 10^8

***/