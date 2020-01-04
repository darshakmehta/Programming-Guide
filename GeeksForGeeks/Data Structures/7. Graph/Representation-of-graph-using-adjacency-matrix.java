import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void print2DMatrix(int[][] graph) {
		for(int i = 0; i < graph.length; i++) {
			for(int j = 0; j < graph[0].length; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		int vertices = 3;
		int[][] graph = new int[vertices + 1][vertices + 1]; /* Assume 0th row and 0th col is 0 */
		
		/* Directed Graph 1 => 2; 2 => 3; 3 => 1 */ 
		
		graph[1][2] = 1;
		graph[2][3] = 1;
		graph[3][1] = 1;
		
		System.out.println("Directed Graph");
		print2DMatrix(graph);
		
		/* Undirected Graph 1 <=> 2; 2 <=> 3; 3 <=> 1 */ 
		
		graph[1][2] = 1;
		graph[2][3] = 1;
		graph[3][1] = 1;
		
		//Symmetric
		
		graph[2][1] = 1;
		graph[3][2] = 1;
		graph[1][3] = 1;
		
		System.out.println("Undirected Graph");
		print2DMatrix(graph);
		
	}
}