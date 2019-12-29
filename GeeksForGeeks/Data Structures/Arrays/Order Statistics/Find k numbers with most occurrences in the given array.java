/***

Given an array of n numbers and a positive integer k. The problem is to find k numbers with most occurrences, i.e., the top k numbers having the maximum frequency. If two numbers have same frequency then the larger number should be given preference. The numbers should be displayed in decreasing order of their frequencies. It is assumed that the array consists of k numbers with most occurrences.

Examples:

Input : arr[] = {3, 1, 4, 4, 5, 2, 6, 1}, 
        k = 2
Output : 4 1
Frequency of 4 = 2
Frequency of 1 = 2
These two have the maximum frequency and
4 is larger than 1.

Input : arr[] = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9},
            k = 4
Output : 5 11 7 10

**/

/** 

Method 1: Using hash table, we create a frequency table which stores the frequency of occurrence of each number in the given array. In the hash table we define (x, y) tuple, where x is the key(number) and y is its frequency in the array. Now we traverse this hash table and create an array freq_arr[] which stores these (number, frequency) tuples. Sort this freq_arr[] on the basis of the conditions defined in the problem statement. Now, print the first k numbers of this freq_arr[].

Time Complexity: O(dlogd), where d is the count of distinct elements in the array.
Auxiliary Space: O(d), where d is the count of distinct elements in the array.

Method 2: Create the array freq_arr[] as described in Method 1 of this post. Now, build the max heap using elements of this freq_arr[]. The root of the max heap should be the most frequent number and in case of conflicts the larger number gets the preference. Now remove the top K numbers of this max heap. C++ STL priority_queue has been used as max heap.

Time Complexity: O(d + K logd), where d is the count of distinct elements in the array.
Auxiliary Space: O(d), where d is the count of distinct elements in the array.

Code: https://ideone.com/UGqtT3 [Method 2]

**/

import java.util.*;
import java.lang.*;
import java.io.*;

class Node implements Comparable<Node> {
	int key;
	int frequency;

	Node(int key, int frequency) {
		this.key = key;
		this.frequency = frequency;
	}

	public int compareTo(Node n) {
		if (this.frequency == n.frequency) {
			return Integer.compare(this.key, n.key);
		}
		return Integer.compare(this.frequency, n.frequency);
	}
}

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int K = sc.nextInt();

		Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		for (int el : arr) {
			hmap.put(el, hmap.getOrDefault(el, 0) + 1);
		}

		PriorityQueue<Node> maxHeap = new PriorityQueue<Node>(Collections.reverseOrder());

		for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
            int key = entry.getKey();
            int frequency = entry.getValue();
            maxHeap.add(new Node(key, frequency));
        }

        for (int i = 0; i < K; i++) {
        	Node top_node = maxHeap.poll();
        	System.out.print(top_node.key + " ");
        }
	}
}



/**

Time Complexity: O(d + K logd), where d is the count of distinct elements in the array.
Auxiliary Space: O(d), where d is the count of distinct elements in the array.

**/