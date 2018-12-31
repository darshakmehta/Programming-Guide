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
	
	// Returns true if the graph contains a cycle, else false. 
	public boolean detectCycle() { /* TODO: check for various test cases */
		boolean[] visited = new boolean[V];

		// Call the recursive helper function to detect cycle in 
        // different DFS trees 
		for(int i = 0; i < V; i++) {
			if( !visited[i] ) // Don't recur for u if already visited 
				if( detectCycleUtil(i, visited, -1) ) {
					return true;
				}
		}
		return false;
	}
	
	public boolean detectCycleUtil(int vertex, boolean[] visited, int parent) {
		
		visited[vertex] = true;
		System.out.print(vertex + " ");

		List<Integer> innerList = list.get(vertex);
		for(int i = 0; i < innerList.size(); i++) {
			Integer in = innerList.get(i);
			if( !visited[in] ) {
				if( detectCycleUtil(in, visited, vertex) ) {
					return true;
				}
			} else if ( in != parent ) {
				return true;
			}
		}

		return false;
	}
	
	
}

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int directedV = 3;

		/* Undirected Graph 1 <=> 2; 2 <=> 3; 3 <=> 1 */
		
		int undirectedV = 5;
		Graph unDirectedGraph = new Graph(undirectedV);
		
		unDirectedGraph.addUndirectedEdge(0, 1);
        unDirectedGraph.addUndirectedEdge(0, 4);
        unDirectedGraph.addUndirectedEdge(1, 2);
        unDirectedGraph.addUndirectedEdge(1, 3);
        unDirectedGraph.addUndirectedEdge(1, 4);
        unDirectedGraph.addUndirectedEdge(2, 3);
        unDirectedGraph.addUndirectedEdge(3, 4);
		
		System.out.println();
		System.out.println("Undirected Graph");
		unDirectedGraph.printGraph();
		
		System.out.println();
		System.out.println("DFS of given Undirected Graph:");
		System.out.println(unDirectedGraph.detectCycle());
	}
}