import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int a[] = new int[size];
		for(int i = 0; i < size; i++){
			a[i] = sc.nextInt();
		}
		int v = sc.nextInt();
		Solution solution = new Solution();
		int result = solution.linearSearch(a, v);
		if(result == -1) {
			System.out.println("Value: " + v + " not found");
		}else {
			System.out.println("Value: "+ v + " found at index " + result);
		}
	}
	
	public int linearSearch(int a[], int value){
		for(int i = 0; i < a.length; i++){
			if(a[i] == value){
				return i;
			}
		}
		return -1;
	}
}

/***

Time complexity: O(n)

Note: Linear search is rarely used, binary search and hash tables provide faster searching compared to Linear Search

***/