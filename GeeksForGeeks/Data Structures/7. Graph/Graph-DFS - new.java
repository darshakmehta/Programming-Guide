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
			for(Integer vertex : vertices) {
				System.out.print(" -> " + vertex);
			}
			System.out.println();
		}
	}
	
	public void dfs(int vertex) {
		boolean[] visited = new boolean[V];
		dfsUtil(vertex, visited);
	}
	
	public void dfsUtil(int startVertex, boolean[] visited) {
		
		visited[startVertex] = true;
		System.out.print(startVertex + " ");

		List<Integer> innerList = list.get(startVertex);
		for (Integer vertex : innerList) {
			if (!visited[vertex]) {
				dfsUtil(vertex, visited);
			}
		}
	}

	public void dfsStack(int startVertex) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[V];
		
		stack.push(startVertex);

		while(!stack.isEmpty()) {
			Integer in = stack.pop();
			
			if(!visited[in]) {
				visited[in] = true;
				System.out.print(in + " ");
			}
			
			List<Integer> innerList = list.get(in);
			
			for (Integer vertex : innerList) {
				if (!visited[vertex]) {
					stack.push(vertex);
				}
			}
		}
	}
	
	public void dfsDisconnected() {
		boolean[] visited = new boolean[V];

		for(int i = 0; i < V; i++) {
			if(!visited[i]) {
				dfsDisconnectedUtil(i, visited);
			}
		}
	}


	public void dfsDisconnectedUtil(int startVertex, boolean[] visited) {
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(startVertex);

		while(!stack.isEmpty()) {
			Integer in = stack.pop();
			
			if(!visited[in]) {
				visited[in] = true;
				System.out.print(in + " ");
			}
			
			List<Integer> innerList = list.get(in);
			for (Integer vertex : innerList) {
				if (!visited[vertex]) {
					stack.push(vertex);
				}
			}
		}
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

		System.out.println("Directed Graph");
		directedGraph.printGraph();
		
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
		System.out.println("DFS of given Directed Graph:");
		directedGraph.dfs(2);
		
		System.out.println();
		System.out.println("DFS of given Undirected Graph:");
		unDirectedGraph.dfs(3);
		
		System.out.println();
		System.out.println("DFS of given Directed Graph using Stack:");
		directedGraph.dfsStack(2);
		
		System.out.println();
		System.out.println("DFS of given Undirected Graph using Stack:");
		unDirectedGraph.dfsStack(3);
		
		System.out.println();
		System.out.println("DFS of given disconnected Undirected Graph using Stack:");
		unDirectedGraph.dfsDisconnected();
	}
}