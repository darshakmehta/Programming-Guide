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
	
	public void bfs() {
		
		boolean[] visited = new boolean[V]; /* Track Non-visited childrens */
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int startVertex = 1; /* Can start from any vertex for connected graph */
		/* Note:  For disconnected graph => check for all vertex */
		
		queue.offer(startVertex);
		visited[startVertex] = true;

		while(!queue.isEmpty()) {
			Integer i = queue.poll();
			System.out.print(i + " ");
			List<Integer> innerList = list.get(i);
			
			for (Integer vertex : innerList) {
				if (!visited[vertex]) {
					queue.offer(vertex);
					visited[vertex] = true;
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
		
		/* Directed Graph */
		
		directedGraph.addDirectedEdge(0, 1);
		directedGraph.addDirectedEdge(1, 2);
		directedGraph.addDirectedEdge(2, 0); 

		System.out.println("Directed Graph");
		directedGraph.printGraph();
		
		/* Undirected Graph */
		
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
		System.out.println("BFS of given Directed Graph:");
		directedGraph.bfs();
		
		System.out.println();
		System.out.println("BFS of given Undirected Graph:");
		unDirectedGraph.bfs();
	}
}