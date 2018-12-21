import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void printAdjacencyList(List<List<Integer>> list) {
		for(int i = 1; i < list.size(); i++) {
			List<Integer> vertices = list.get(i);
			System.out.print("Vertice " + i + " ");
			for(Integer vertice : vertices) {
				System.out.print(" -> " + vertice);
			}
			System.out.println();
		}
	}
	
	public static void reinitialize(List<List<Integer>> list, int vertices) {
		
		List<Integer> vertex = new ArrayList<Integer>();
		list.add(vertex); /* Just for understanding Add empty 0th row in the list */
		
		for(int i = 1; i < vertices; i++) {
			vertex = new ArrayList<Integer>();
			list.add(vertex);
		}
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		int vertices = 3;
		List<List<Integer>> list = new ArrayList<List<Integer>>(); /* Assume 0th row is kept empty*/
		
		reinitialize(list, vertices + 1);
		
		/* Directed Graph 1 => 2; 2 => 3; 3 => 1; 3 => 2 */
		
		list.get(1).add(2);
		list.get(2).add(3);
		list.get(3).add(1);
		list.get(3).add(2);
		
		System.out.println();
		System.out.println("Directed Graph");
		printAdjacencyList(list);
		
		/* Undirected Graph 1 <=> 2; 2 <=> 3; 3 <=> 1 */
		
		list = new ArrayList<List<Integer>>();
		reinitialize(list, vertices + 1);
		
		list.get(1).add(2);
		list.get(2).add(3);
		list.get(3).add(1);
	
		//Symmetric
		list.get(2).add(1);
		list.get(3).add(2);
		list.get(1).add(3);
		
		System.out.println();
		System.out.println("Undirected Graph");
		printAdjacencyList(list);
		
	}
}