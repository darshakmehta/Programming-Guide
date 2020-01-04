import java.util.*;
import java.lang.*;
import java.io.*;

class Graph {
	int V;
	List<List<Integer>> list;

	Graph(int V) {
		this.V = V;
		list = new ArrayList<List<Integer>>();
		for(int i = 0; i < V; i++) {
			List<Integer> vertex = new ArrayList<Integer>();
			list.add(vertex);
		}
	}
	
	public void addDirectedEdge(int u, int v) {
		this.list.get(u).add(v);
	}
	
	public void addUndirectedEdge(int u, int v) {
		this.list.get(u).add(v);
		this.list.get(v).add(u); // symmetric
	}

	public void printAdjacencyList() {
		
		for(int i = 0; i < V; i++) {
			List<Integer> vertices = list.get(i);
			
			System.out.print("Vertice " + i + " ");
			
			for( Integer vertex : vertices) {
				System.out.print(" -> " + vertex);
			}
			
			System.out.println();
		}
	}
}

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int V = 3;
		Graph directedGraph = new Graph(V);
		
		/* Directed Graph 1 => 2; 2 => 3; 3 => 1; 3 => 2 */
		
		directedGraph.addDirectedEdge(0, 1);
		directedGraph.addDirectedEdge(1, 2);
		directedGraph.addDirectedEdge(2, 0);
		directedGraph.addDirectedEdge(2, 1);

		System.out.println("Directed Graph");
		directedGraph.printAdjacencyList();
		
		/* Undirected Graph 1 <=> 2; 2 <=> 3; 3 <=> 1 */
		
		Graph unDirectedGraph = new Graph(V);
		
		unDirectedGraph.addUndirectedEdge(0, 1);
		unDirectedGraph.addUndirectedEdge(1, 2);
		unDirectedGraph.addUndirectedEdge(2, 0);
		
		System.out.println();
		System.out.println("Undirected Graph");
		unDirectedGraph.printAdjacencyList();
		
	}
}