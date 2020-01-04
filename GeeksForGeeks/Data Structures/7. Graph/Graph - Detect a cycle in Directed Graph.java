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
		this.list.get(v).add(u); //symmetric
	}

	public void printGraph() {
		for(int i = 0; i < V; i++) {
			List<Integer> vertices = list.get(i);
			System.out.println("Adjacency list of vertex "+ i);
            System.out.print("head");
			for(Integer vertice : vertices) {
				System.out.print(" -> " + vertice);
			}
			System.out.println();
		}
	}
	
	public boolean detectCycle() { /* TODO: check for various test cases */
		boolean[] visited = new boolean[V];
		boolean[] recStackVisited = new boolean[V];

		for(int i = 0; i < V; i++) {
			if( detectCycleUtil(i, visited, recStackVisited) ) {
				return true;
			}
		}
		return false;
	}
	
	public boolean detectCycleUtil(int vertex, boolean[] visited, boolean[] recStackVisited) {
		
		if( recStackVisited[vertex] ) return true;
		if( visited[vertex] ) return false;

		visited[vertex] = true;
		recStackVisited[vertex] = true;

		System.out.print(vertex + " ");

		List<Integer> innerList = list.get(vertex);
		for(int i = 0; i < innerList.size(); i++) {
			Integer in = innerList.get(i);
			if( detectCycleUtil(in, visited, recStackVisited) ) {
				return true;
			}
		}

		recStackVisited[vertex] = false;

		return false;
	}
	
	
}

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int directedV = 3;
		Graph directedGraph = new Graph(directedV);
		
		/* Directed Graph 1 => 2; 2 => 3; 3 => 1; 3 => 2 */
		
		directedGraph.addDirectedEdge(0, 1);
		directedGraph.addDirectedEdge(1, 2);
		directedGraph.addDirectedEdge(2, 0); 
		/* Works well for self loop and back edge going to its ancestor */

		System.out.println("Directed Graph");
		directedGraph.printGraph();
		
		System.out.println();
		System.out.println("DFS of given Directed Graph:");
		System.out.println(directedGraph.detectCycle());
	}
}