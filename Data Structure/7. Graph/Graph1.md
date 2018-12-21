# Graph Data Structure And Algorithms

A Graph is a non-linear data structure consisting of nodes and edges. 
The nodes are sometimes also referred to as vertices and the edges are lines or arcs that connect any two nodes in the graph. 

More formally a Graph can be defined as, `A Graph consists of a finite set of vertices(or nodes) and set of Edges which connect a pair of nodes.`

[Following is an example of an undirected graph with 5 vertices](https://www.geeksforgeeks.org/wp-content/uploads/undirectedgraph.png)

In the above Graph, the set of vertices V = {0,1,2,3,4} and the set of edges E = {0 -> 1, 1 -> 2, 2 -> 3, 3 -> 4, 0 -> 4, 1 -> 4, 1 -> 3}.

Graphs are used to solve many real-life problems. 
Graphs are used to represent networks. 
The networks may include paths in a city or telephone network or circuit network. 
Graphs are also used in social networks like linkedIn, Facebook. 
For example, in Facebook, each person is represented with a vertex(or node). 
`Each node is a structure` and contains information like person id, name, gender, locale etc.

Note: [Applications of Graph](https://en.wikipedia.org/wiki/Graph_theory#Applications)

# Graph and its representations

Graph is a data structure that consists of following two components:

1. A finite set of vertices also called as nodes.
2. A finite set of ordered pair of the form (u, v) called as edge. 

The pair is ordered because (u, v) is not same as (v, u) in case of a directed graph(di-graph). 
The pair of the form (u, v) indicates that there is an edge from vertex u to vertex v. The edges may contain weight/value/cost.

## Representation

Following two are the most commonly used representations of a graph.

1. Adjacency Matrix
2. Adjacency List

There are other representations also like, Incidence Matrix and Incidence List.

The choice of the graph representation is situation specific. It totally depends on the type of operations to be performed and ease of use.

## [Adjacency Matrix:](https://ideone.com/kpxPQm)

Adjacency Matrix is a 2D array of size V x V where V is the number of vertices in a graph. 
Let the 2D array be adj[][], a slot adj[i][j] = 1 indicates that there is an edge from vertex i to vertex j.

`Adjacency matrix for undirected graph is always symmetric.`

Adjacency Matrix is also used to represent weighted graphs. If adj[i][j] = w, then there is an edge from vertex i to vertex j with weight w.

[The adjacency matrix for the above example graph is](https://cdncontribute.geeksforgeeks.org/wp-content/uploads/adjacencymatrix.png)

`Pros`: Representation is easier to implement and follow. Removing an edge takes O(1) time. Queries like whether there is an edge from vertex ‘u’ to vertex ‘v’ are efficient and can be done O(1).

`Cons`: Consumes more space O(V^2). Even if the graph is sparse(contains less number of edges), it consumes the same space. `Adding a vertex is O(V^2) time.`

## [Adjacency List:](https://ideone.com/4915nw)

An array of lists is used. Size of the array is equal to the number of vertices. 

Let the array be array[]. An entry array[i] represents the list of vertices adjacent to the ith vertex. This representation can also be used to represent a weighted graph. 

`The weights of edges can be represented as lists of pairs. `

[Following is adjacency list representation of the above graph](https://cdncontribute.geeksforgeeks.org/wp-content/uploads/listadjacency.png)

Tips:

1. Note that in below implementation, we use dynamic arrays (vector in C++/ArrayList in Java) to represent adjacency lists instead of linked list. The vector implementation has advantages of cache friendliness.

`Pros`: Saves space O(|V|+|E|) . In the worst case, there can be C(V, 2) number of edges in a graph thus consuming O(V^2) space. Adding a vertex is easier.

`Cons`: Queries like whether there is an edge from vertex u to vertex v are not efficient and can be done O(V).

### Examples of Sparse Graph : FB, LinkedIn
### Examples of Dense Graph : Employees at Google, Students in a university.

# [Breadth First Search or BFS for a Graph](https://ideone.com/bibcQS)

`Breadth First Traversal (or Search) for a graph is similar to Breadth First Traversal of a tree `

The only catch here is, unlike trees, graphs may contain cycles, so we may come to the same node again. 
To avoid processing a node more than once, we use a boolean visited array. For simplicity, it is assumed that all vertices are reachable from the starting vertex.

For example, in the following graph, we start traversal from vertex 2. When we come to vertex 0, we look for all adjacent vertices of it. 2 is also an adjacent vertex of 0. If we don’t mark visited vertices, then 2 will be processed again and it will become a non-terminating process. 

[A Breadth First Traversal of the following graph is 2, 0, 3, 1.](https://cdncontribute.geeksforgeeks.org/wp-content/uploads/bfs-5.png)

[Following are the implementations of simple Breadth First Traversal from a given source.](https://ideone.com/bibcQS)

Note that the above code traverses only the vertices reachable from a given source vertex. All the vertices may not be reachable from a given vertex (example Disconnected graph). To print all the vertices, we can modify the BFS function to do traversal starting from all nodes one by one

`Time Complexity`: O(V+E) where V is number of vertices in the graph and E is number of edges in the graph.

# [Depth First Search or DFS for a Graph](https://ideone.com/gqpN2H)

Depth First Traversal (or Search) for a graph is similar to Depth First Traversal of a tree. 

The only catch here is, unlike trees, graphs may contain cycles, so we may come to the same node again. To avoid processing a node more than once, we use a boolean visited array.

For example, in the following graph, we start traversal from vertex 2. 
When we come to vertex 0, we look for all adjacent vertices of it. 2 is also an adjacent vertex of 0. 
If we don’t mark visited vertices, then 2 will be processed again and it will become a non-terminating process. 

[Depth First Traversal of the following graph is 2, 0, 1, 3.](https://cdncontribute.geeksforgeeks.org/wp-content/uploads/cycle.png)

[Following are implementations of simple Depth First Traversal.](https://ideone.com/gqpN2H)

The above code traverses only the vertices reachable from a given source vertex. All the vertices may not be reachable from a given vertex (example Disconnected graph). To do complete DFS traversal of such graphs, we must call DFSUtil() for every vertex. Also, before calling DFSUtil(), we should check if it is already printed by some other call of DFSUtil(). Following implementation does the complete graph traversal even if the nodes are unreachable. The differences from the above code are highlighted in the below code.

Add this piece of code in your dfs() to check for every node

	for (int i = 0; i < V; i++) 
	    if (!visited[i]) 
	        DFSUtil(i, visited); 

`Time Complexity`: O(V+E) where V is number of vertices in the graph and E is number of edges in the graph.

# Iterative Depth First Traversal of Graph

The recursive implementation uses function call stack. In iterative implementation, an explicit stack is used to hold visited vertices.

The implementation is similar to BFS, the only difference is queue is replaced by stack.

Note that the [above implementation](https://ideone.com/irtBlW) prints only vertices that are reachable from a given vertex. For example, if we remove edges 0-3 and 0-2, the above program would only print 0. To print all vertices of a graph, we need to call DFS for every vertex. [Below is implementation for the same.](https://ideone.com/mdETJ2)

# Applications of Depth First Search

Depth-first search (DFS) is an algorithm (or technique) for traversing a graph.

Following are the problems that use DFS as a building block.

1. For an unweighted graph, DFS traversal of the graph produces the minimum spanning tree and all pair shortest path tree.

2. Detecting cycle in a graph 
A graph has cycle if and only if we see a back edge during DFS. So we can run DFS for the graph and check for back edges. (See [this](http://people.csail.mit.edu/thies/6.046-web/recitation9.txt) for details)

3. Path Finding

We can specialize the DFS algorithm to find a path between two given vertices u and z.

i) Call DFS(G, u) with u as the start vertex.
ii) Use a stack S to keep track of the path between the start vertex and the current vertex.
iii) As soon as destination vertex z is encountered, return the path as the contents of the stack

See [this](http://ww3.algorithmdesign.net/handouts/DFS.pdf) for details.

4. Topological Sorting

Topological Sorting is mainly used for scheduling jobs from the given dependencies among jobs. In computer science, applications of this type arise in instruction scheduling, ordering of formula cell evaluation when recomputing formula values in spreadsheets, logic synthesis, determining the order of compilation tasks to perform in makefiles, data serialization, and resolving symbol dependencies in linkers [4].

5. To test if a graph is bipartite

We can augment either BFS or DFS when we first discover a new vertex, color it opposited its parents, and for each other edge, check it doesn’t link two vertices of the same color. The first vertex in any connected component can be red or black! See [this](http://www8.cs.umu.se/kurser/TDBAfl/VT06/algorithms/LEC/LECTUR16/NODE16.HTM) for details.

6. Finding Strongly Connected Components of a graph 

A directed graph is called strongly connected if there is a path from each vertex in the graph to every other vertex. (See [this](https://www.geeksforgeeks.org/strongly-connected-components/) for DFS based algo for finding Strongly Connected Components)

7) Solving puzzles with only one solution, such as mazes. 

(DFS can be adapted to find all solutions to a maze by only including nodes on the current path in the visited set.)

# Applications of Breadth First Traversal

applications of Breadth First Search are discussed.

1. Shortest Path and Minimum Spanning Tree for unweighted graph 

In an unweighted graph, the shortest path is the path with least number of edges. With Breadth First, we always reach a vertex from given source using the minimum number of edges. Also, in case of unweighted graphs, any spanning tree is Minimum Spanning Tree and we can use either Depth or Breadth first traversal for finding a spanning tree.

2. Peer to Peer Networks. 

In Peer to Peer Networks like BitTorrent, Breadth First Search is used to find all neighbor nodes.

3. Crawlers in Search Engines: 

Crawlers build index using Breadth First. The idea is to start from source page and follow all links from source and keep doing same. Depth First Traversal can also be used for crawlers, but the advantage with Breadth First Traversal is, depth or levels of the built tree can be limited.

4. Social Networking Websites: 

In social networks, we can find people within a given distance ‘k’ from a person using Breadth First Search till ‘k’ levels.

5. GPS Navigation systems: 

Breadth First Search is used to find all neighboring locations.

6. Broadcasting in Network: 

In networks, a broadcasted packet follows Breadth First Search to reach all nodes.

7. In Garbage Collection: Breadth First Search is used in copying garbage collection using [Cheney’s algorithm](http://en.wikipedia.org/wiki/Cheney%27s_algorithm). Refer [this](https://lambda.uta.edu/cse5317/notes/node48.html) and for details. Breadth First Search is preferred over Depth First Search because of better locality of reference:

8. [Cycle detection in undirected graph](https://www.geeksforgeeks.org/detect-cycle-undirected-graph/): 

In undirected graphs, either Breadth First Search or Depth First Search can be used to detect cycle. In directed graph, only depth first search can be used.

9. [Ford–Fulkerson algorithm](https://www.geeksforgeeks.org/ford-fulkerson-algorithm-for-maximum-flow-problem/)

In Ford-Fulkerson algorithm, we can either use Breadth First or Depth First Traversal to find the maximum flow. Breadth First Traversal is preferred as it reduces worst case time complexity to O(VE2).

10. [To test if a graph is Bipartite](https://www.geeksforgeeks.org/bipartite-graph/) We can either use Breadth First or Depth First Traversal.

11. Path Finding We can either use Breadth First or Depth First Traversal to find if there is a path between two vertices.

12. Finding all nodes within one connected component: We can either use Breadth First or Depth First Traversal to find all nodes reachable from a given node.

Many algorithms like [Prim’s Minimum Spanning Tree](https://www.geeksforgeeks.org/greedy-algorithms-set-5-prims-minimum-spanning-tree-mst-2/) and [Dijkstra’s Single Source Shortest Path](https://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/) use structure similar to Breadth First Search.

There can be many more applications as Breadth First Search is one of the core algorithms for Graphs.

# {TODO} [Graph representations using set and hash](https://www.geeksforgeeks.org/graph-representations-using-set-hash/)

# Find a Mother Vertex in a Graph

### What is a Mother Vertex?
A mother vertex in a graph G = (V,E) is a vertex v such that all other vertices in G can be reached by a path from v.

[Example](https://www.geeksforgeeks.org/wp-content/uploads/mother1-1024x408.png)

There can be more than one mother vertices in a graph. We need to output anyone of them. For example, [in the below graph](https://www.geeksforgeeks.org/wp-content/uploads/MotherVertex-300x172.png), vertices 0, 1 and 2 are mother vertices.

# Facts

[Six degrees of separation](https://en.wikipedia.org/wiki/Six_degrees_of_separation)

# Important Links

0. https://en.wikipedia.org/wiki/Graph_%28abstract_data_type%29
1. http://www8.cs.umu.se/kurser/TDBAfl/VT06/algorithms/LEC/LECTUR16/NODE16.HTM
2. http://www.personal.kent.edu/~rmuhamma/Algorithms/MyAlgorithms/GraphAlgor/depthSearch.htm
3. http://ww3.algorithmdesign.net/handouts/DFS.pdf
4. https://en.wikipedia.org/wiki/Depth-first_search
5. [Kosaraju's Strongly Connected Component Algorithm](https://www.geeksforgeeks.org/strongly-connected-components/)


