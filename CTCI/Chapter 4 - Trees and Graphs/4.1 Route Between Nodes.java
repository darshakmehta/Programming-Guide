import java.util.*;
import java.lang.*;
import java.io.*;

class Graph
{

	int V;
	LinkedList<Integer> adjListArray[];

	Graph(int V) {
		this.V = V;
		adjListArray = new LinkedList[V]; //generic array creation
		for(int i = 0; i < V ; i++){
            adjListArray[i] = new LinkedList();
        }
	}

	public void addEdge(int u, int v) {
		this.adjListArray[u].addFirst(v);
	}

	public void printGraph() {
		for(int v = 0; v < V; v++) {
			System.out.println("Adjacency list of vertex "+ v);
            System.out.print("head");
            for(Integer pCrawl: adjListArray[v]){
                System.out.print(" -> "+pCrawl);
            }
            System.out.println("\n");
		}
	}

	public boolean isRoute(int start, int end) {
		if(start == end)
			return true;

		//Mark all vertices as not visited
		boolean visited[] = new boolean[V];

		//Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();

		visited[start] = true;
		queue.add(start);

		while(queue.size() > 0) {
			start = queue.poll();

			Iterator<Integer> i = adjListArray[start].listIterator();
			while(i.hasNext()) {
				int n = i.next();
				if( !visited[n]) {
					if(n == end) {
						return true;
					} else {
					visited[n] = true;
					queue.add(n);
					}
				}
			}
		}
		return false;

	}

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int V = 5;
		Graph graph = new Graph(V);
		graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.printGraph();
        System.out.println(graph.isRoute(1, 4));
	}
}


/***

TODO: Implement DFS to find if route exist

***/