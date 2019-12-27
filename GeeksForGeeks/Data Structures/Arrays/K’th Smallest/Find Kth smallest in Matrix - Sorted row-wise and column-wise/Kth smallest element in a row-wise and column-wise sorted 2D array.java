/***
Question: https://www.geeksforgeeks.org/kth-smallest-element-in-a-row-wise-and-column-wise-sorted-2d-array-set-1/
Given an n x n matrix, where every row and column is sorted in non-decreasing order. Find the kth smallest element in the given 2D array.
For example, consider the following 2D array.

Input:
    10, 20, 30, 40
    15, 25, 35, 45
    24, 29, 37, 48
    32, 33, 39, 50

Output: The 3rd smallest element is 20 and 7th smallest element is 30
Code: https://ideone.com/Xj3znX
**/

import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
	int value;
	int row;
	int col;

	Node(int value, int row, int col) {
		this.value = value;
		this.row = row;
		this.col = col;
	}
	
	public void printNode() {
		System.out.println("Value: " + this.value + " row: " + this.row + " col: " + this.col);
	}
}

class Heap {

	private static int heap_size;
	private final static int minNode = 1;
	private final static int INT_MAX = Integer.MAX_VALUE;

	public static int left(int i) {
		return 2 * i;
	}

	public static int right(int i) {
		return  2 * i + 1;
	}

	public static void swapNode(Node[] heap, int i, int smallest) {
		Node temp = heap[i];
		heap[i] = heap[smallest];
		heap[smallest] = temp;
	}

	public static void minHeapify(Node[] heap, int i) {
		int left = left(i);
		int right = right(i);
		int smallest = i;

		if (left <= Heap.heap_size && heap[left].value < heap[i].value) {
			smallest = left;
		}

		if (right <= Heap.heap_size && heap[right].value < heap[smallest].value) {
			smallest = right;
		}

		if (smallest != i) {
			swapNode(heap, i, smallest);
			minHeapify(heap, smallest);
		}
	}

	public static void extractMin(int[][] arr, Node[] heap) {
		
		int new_row = heap[minNode].row + 1;
		int new_col = heap[minNode].col;
		int new_value = (new_row >= Heap.heap_size) ? INT_MAX : arr[new_row][new_col];
		
		Node new_node = new Node(new_value, new_row, new_col);
		heap[minNode] = new_node;
		
		minHeapify(heap, minNode);
	}

	public static String findKthSmallest(int[][] arr, Node[] heap, int row, int col, int K) {
		
		if (K <= 0 || K > (row * col)) 
			return "-1";

		for (int i = 1; i < K; i++) { // "K - 1" extractMin() calls
			extractMin(arr, heap);
		}

		return "Found: " + heap[minNode].value + 
				" at row: " + heap[minNode].row + 
				" col: " + heap[minNode].col;
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();

		int[][] arr = new int[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int K = sc.nextInt();

		Node[] heap = new Node[col + 1]; // 1-index Heap
		Heap.heap_size = col;

		// Since it is sorted row-wise, we do not have to do initial buildMinHeap 
		for (int i = 1; i <= col; i++) {
			Node new_node = new Node(arr[0][i - 1], 0, i - 1); // "i - 1" bcoz we have 1-index Heap
			heap[i] = new_node;
		}

		System.out.println(K + "th/rd/nd/st smallest element is " + findKthSmallest(arr, heap, row, col, K));
	}
}


/**

Time Complexity:

1. O(m) to build Heap (where m = column size)
2. Heapify K times which takes O(K * log K) times
Overall: O(m + K * log K)

*/