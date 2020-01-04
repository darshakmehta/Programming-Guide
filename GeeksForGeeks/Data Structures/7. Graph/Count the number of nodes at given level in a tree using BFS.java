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

	public void printAdjacencyList() {
		for(int i = 0; i < V; i++) {
			List<Integer> vertices = list.get(i);
			System.out.print("Vertice " + i + " ");
			for(Integer vertice : vertices) {
				System.out.print(" -> " + vertice);
			}
			System.out.println();
		}
	}
	
	public int bfs() {
		
		int rootVertex = 0; /* Given Root */
		int level = 4; /* Find #nodes at k level */
		
		if(level == 0) return 1;
		else if(level == 1) return list.get(0).size();
		else {
			Queue<Integer> queue = new LinkedList<Integer>();
			boolean[] visited = new boolean[V];
			
			queue.offer(rootVertex);
			visited[rootVertex] = true;
			
			int iLevel = 0;
			int count = queue.size();
			while(iLevel != level) {
				for(int i = 0; i < count; i++) {
					Integer in = queue.poll();
					List<Integer> innerList = list.get(in);
					for (Integer vertex : innerList) {
						if(!visited[vertex]) {
							queue.offer(vertex);
							visited[vertex] = true;
						}
					}
				}
				iLevel++;
				count = queue.size();
				System.out.print("Level " + iLevel + " " + count);
				System.out.println(queue);
			}
			return count;
		}
	}
}

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int V = 7;
		Graph directedGraph = new Graph(V);
		
		directedGraph.addDirectedEdge(0, 1);
		directedGraph.addDirectedEdge(0, 2);
		directedGraph.addDirectedEdge(1, 3);
		directedGraph.addDirectedEdge(1, 4);
		directedGraph.addDirectedEdge(1, 5);
		directedGraph.addDirectedEdge(2, 6);
		
		System.out.println("Test Case 1");
		System.out.println("Result " + directedGraph.bfs());
		
		directedGraph = new Graph(V);
		directedGraph.addDirectedEdge(0, 1);
		directedGraph.addDirectedEdge(0, 2);
		directedGraph.addDirectedEdge(1, 3);
		directedGraph.addDirectedEdge(2, 3);
		directedGraph.addDirectedEdge(3, 4);
		directedGraph.addDirectedEdge(4, 5);
		directedGraph.addDirectedEdge(5, 6);

		System.out.println("Test Case 2");
		System.out.println("Result " + directedGraph.bfs());
	}
}