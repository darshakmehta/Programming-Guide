/***

Given two equally sized arrays (A, B) and N (size of both arrays).
A sum combination is made by adding one element from array A and another element of array B. Display the maximum K valid sum combinations from all the possible sum combinations.

Examples:

Input :  A[] : {3, 2} 
         B[] : {1, 4}
         K : 2 [Number of maximum sum
               combinations to be printed]
Output : 7    // (A : 3) + (B : 4)
         6    // (A : 2) + (B : 4)

Input :  A[] : {4, 2, 5, 1}
         B[] : {8, 0, 3, 5}
         K : 3
Output : 13   // (A : 5) + (B : 8)
         12   // (A : 4) + (B :  8)
         10   // (A : 2) + (B : 8)  

Code: https://ideone.com/TYHzMr
**/

/***

Method 1: Find all combination O(n^2) and add to max Heap and do K extractMax() Operations.

Method 2: Find all combination O(n^2) and add to min Heap of size K and compare peek() with next sum if it is greater pop and push. Finally, all the K elements of Heap are the max combinations

Method 3: Sorting, Max Heap and Set (TC: O(N log N) assuming K <= N))

**/

import java.util.*;
import java.lang.*;
import java.io.*;

class Pair {
	int x;
	int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Node implements Comparable<Node> {
	int value;
	Pair pair;

	Node(int value, Pair pair) {
		this.value = value;
		this.pair = pair;
	}

  // Implemented to avoid ClassCastException
  public int compareTo(Node n) {
    return 0;
  }
}

class Main
{
	public static void KMaxCombinations(int[] arr1, int[] arr2, int n, int K) {

		Arrays.sort(arr1);
		Arrays.sort(arr2);

		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		Set<Pair> set = new HashSet<Pair>();

		Pair new_pair = new Pair(n - 1, n - 1);
		Node new_node = new Node((arr1[n - 1] + arr2[n - 1]), new_pair);
		
		queue.add(new_node);
		set.add(new_pair);

		for (int i = 0; i < K; i++) {

			Node top_node = queue.poll();

			System.out.println(top_node.value);

			int x = top_node.pair.x;
			int y = top_node.pair.y;

			int sum = arr1[x - 1] + arr2[y];

			new_pair = new Pair(x - 1, y);

			if (!set.contains(new_pair)) {
				queue.add(new Node(sum, new_pair));
				set.add(new_pair);
			}

			sum = arr1[x] + arr2[y - 1];
			new_pair = new Pair(x, y - 1);

			if (!set.contains(new_pair)) {
				queue.add(new Node(sum, new_pair));
				set.add(new_pair);
			}
		}
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];

		for (int i = 0; i < n; i++) {
			arr1[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			arr2[i] = sc.nextInt();
		}

		int K = sc.nextInt();

		KMaxCombinations(arr1, arr2, n, K);
	}
}