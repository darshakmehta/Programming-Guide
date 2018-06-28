//Question : Describe a Θ(nlgn)-time algorithm that, given a set S of n integers and another integer x, determines whether or not there exists two elements of S whose sum is exactly x.

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		int a[] = new int[size];
		for(int i = 0; i < size; i++){
			a[i] = sc.nextInt();
		}
		int result = -1;
		int v = sc.nextInt();
		Ideone ideone = new Ideone();
		for(int i = 0; i< a.length ;i++){
			int key = a[i];
			result = ideone.binarySearch(a, v - key);
			if(result != -1)
				break;
		}
		
		if(result == -1) {
			System.out.println("Sum: " + v + " not found");
		}else {
			System.out.println("Sum: "+ v + " found");
		}
	}
	
	public int binarySearch(int a[], int value){
		int low = 0;
		int high = a.length - 1;
		int mid;
		while(low <=high){
			mid =  (low + high) / 2;
			if(a[mid] == value)
				return mid;
			else if(a[mid] < value){
				low = mid + 1;
			}
			else if(a[mid] > value){
				high = mid - 1;
			}
		}
		return -1;
	}
}


//Solution 2

First we sort S. Afterwards, we iterate it and for each element i we perform a binary search to see if there is an element equal to x−i. If one is found, the algorithm returns true. Otherwise, it returns false.

We iterate n elements and perform binary search for each on in an n-sized array, which leads to Θ(nlgn)-time. If we sort first (with merge sort) it will introduce another Θ(nlgn) time, that would change the constant in the final algorithm, but not the asymptotic time.

Here's the pseudocode:

PAIR-EXISTS(S, x):
  A = MERGE-SORT(S)

  for i = 1 to S.length
      if BINARY-SEARCH(A, x - S[i]) != NIL
          return true

  return false