import java.util.*;
import java.lang.*;
import java.io.*;

class Heap {

	int heap_size;
	
	public int left(int i) {
		return (2*i);
	}
	
	public int right(int i) {
		return (2*i + 1);
	}
	
	public int parent(int i) {
		return (int)Math.floor(i/2);
	}
	
	public void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public void maxHeapify(int a[], int i) {
		int l = left(i);
		int r = right(i);
		int largest;
		if(l <= heap_size && a[l] > a[i])
			largest = l;
		else
			largest = i;
		if(r <= heap_size && a[r] > a[largest])
			largest = r;
		if(largest != i) {
			swap(a, i, largest);
			maxHeapify(a, largest);
		}
	}
	
	public void buildMaxHeap(int a[], int n) {
		for(int i = (int)Math.floor(n/2); i >= 1; i--) {
			maxHeapify(a,i);
		}
	}
	
	public void heapSort(int a[], int n) {
		buildMaxHeap(a, n);
		for(int i = n; i >= 2; i--) {
			swap(a, 1, i);
			heap_size--;
			maxHeapify(a, 1);
		}
	}
	
	public int heapMaximum(int a[]) {
		return a[1];
	}
	
	public int extractMax(int a[]) {
		if(heap_size < 1) {
			System.out.println("heap underflow");
			return -1;
		}
		int max = a[1];
		a[1] = a[heap_size];
		heap_size--;
		maxHeapify(a,1);
		return max;
	}
	
	public void heapIncreaseKey(int a[], int i, int key) {
		if(key < a[i]) {
			System.out.println("new key is smaller than current key");
			return;
		}
		a[i] = key;
		while(i>1 && a[parent(i)] < a[i]) {
			swap(a, i, parent(i));
			i = parent(i);
		}
	}
	
	public void heapEfficientIncreaseKey(int a[], int i, int key) {
		if(key < a[i]) {
			System.out.println("new key is smaller than current key");
			return;
		}
		while(i>1 && a[parent(i)] < key) {
			//swap(a, i, parent(i)); 
			//change swaps to single assignment operation
			a[i] = a[parent(i)];
			i = parent(i);
		}
		a[i] = key;
	}
	
	public void maxHeapInsert(int a[], int key) {
		heap_size++;
		a[heap_size] = Integer.MIN_VALUE;
		heapEfficientIncreaseKey(a, heap_size, key);
	}
	
	public void heapDelete(int a[], int i) {
		a[i] = a[heap_size];
		heap_size--;
		maxHeapify(a, i);
	}
	
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //number of elements
		int a[] = new int[20];
		for(int i = 1; i<=n; i++) {
			a[i] = sc.nextInt();
		}
		
		System.out.println("Before Build Heap");
		for(int i = 1; i<=n; i++)
			System.out.print(a[i] + " ");
		System.out.println();	
		
		Heap heap = new Heap();
		heap.heap_size = n;
		heap.buildMaxHeap(a,n);
		
		System.out.println();	
		System.out.println("After Build Heap");
		for(int i = 1; i<=heap.heap_size; i++)
			System.out.print(a[i] + " ");
		
		int max = heap.heapMaximum(a);
		System.out.println("Maximum: " + max);
		
		int extractMaximum = heap.extractMax(a);
		System.out.println("extractMaximum: " + extractMaximum);
		heap.heapIncreaseKey(a,1,16);
		heap.heapEfficientIncreaseKey(a,12,17);
		heap.maxHeapInsert(a,0);
		heap.maxHeapInsert(a,15);
		heap.heapDelete(a,12);
		
		System.out.println();	
		System.out.println("After");
		for(int i = 1; i<=heap.heap_size; i++)
			System.out.print(a[i] + " ");
		
	}
}