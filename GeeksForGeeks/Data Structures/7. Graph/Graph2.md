# Floyd Warshall Algorithm - All Pairs Shortest Path problem

The Floyd Warshall Algorithm is for solving the All Pairs Shortest Path problem. The problem is to find shortest distances between every pair of vertices in a given edge weighted directed Graph.

## [Tutorial](https://www.youtube.com/watch?v=LwJdNfdLF9s)

`Given directed or undirected graph, Floyd Warshall Algorithm is used to find the minimum distance between all pairs of vertices in the graph. Floyd Warshall Algorithm is a Dynamic Programming Algorithm, it works with negative edges on the graph and with variation it can also detect negative weight cycle in the graph. There are many applications of Floyd Warshall Algorithm like Clean's algorithm or transitive closure or widest path in the graph.`

# To check if there is negative weight cycle?
Solution: If applying floyd gives you a distance matrix having negative values in the diagonal, it will contain negative weight cycle.

## [Floyd Warshall Algorithm](https://ideone.com/h71hmW)

We initialize the solution matrix same as the input graph matrix as a first step. 

Then we update the solution matrix by considering all vertices as an intermediate vertex. 

The idea is to one by one pick all vertices and updates all shortest paths which include the picked vertex as an intermediate vertex in the shortest path. 

When we pick vertex number k as an intermediate vertex, we already have considered vertices {0, 1, 2, .. k-1} as intermediate vertices. 

For every pair (i, j) of the source and destination vertices respectively, there are two possible cases.

1. k is not an intermediate vertex in shortest path from i to j. We keep the value of dist[i][j] as it is.
2. k is an intermediate vertex in shortest path from i to j. We update the value of dist[i][j] as dist[i][k] + dist[k][j] if dist[i][j] > dist[i][k] + dist[k][j]

[The following figure shows the above optimal substructure property in the all-pairs shortest path problem.](https://cdncontribute.geeksforgeeks.org/wp-content/uploads/dpFloyd-Warshall-.jpg)

# [Transitive closure of a graph](https://ideone.com/eKNo4K)

Given a directed graph, find out if a vertex j is reachable from another vertex i for all vertex pairs (i, j) in the given graph. Here reachable mean that there is a path from vertex i to j. 

## [The reach-ability matrix is called transitive closure of a graph.](https://contribute.geeksforgeeks.org/wp-content/uploads/transitiveclosure.png)

`The graph is given in the form of adjacency matrix say ‘graph[V][V]’ where graph[i][j] is 1 if there is an edge from vertex i to vertex j or i is equal to j, otherwise graph[i][j] is 0.`

[Floyd Warshall Algorithm](https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/) can be used, we can calculate the distance matrix dist[V][V] using Floyd Warshall, if dist[i][j] is infinite, then j is not reachable from i, otherwise j is reachable and value of dist[i][j] will be less than V.

Instead of directly using Floyd Warshall, we can optimize it in terms of space and time, for this particular problem. Following are the optimizations:

1) Instead of integer resultant matrix (dist[V][V] in floyd warshall), we can create a boolean reach-ability matrix reach[V][V] (we save space). The value reach[i][j] will be 1 if j is reachable from i, otherwise 0.

2) Instead of using arithmetic operations, we can use logical operations. For arithmetic operation ‘+’, logical and ‘&&’ is used, and for min, logical or ‘||’ is used. (We save time by a constant factor. Time complexity is same though)

# [Transitive Closure of a Graph using DFS](https://ideone.com/r2AqoQ)

Given a directed graph, find out if a vertex v is reachable from another vertex u for all vertex pairs (u, v) in the given graph. Here reachable mean that there is a path from vertex u to v. 

[The reach-ability matrix is called transitive closure of a graph.](https://cdncontribute.geeksforgeeks.org/wp-content/uploads/transitive-closer-graph.png)

Below are abstract steps of algorithm.

1. Create a matrix tc[V][V] that would finally have transitive closure of given graph. Initialize all entries of tc[][] as 0.

2. Call DFS for every node of graph to mark reachable vertices in tc[][]. In recursive calls to DFS, we don’t call DFS for an adjacent vertex if it is already marked as reachable in tc[][].

Below is implementation of the above idea. The code uses adjacency list representation of input graph and builds a matrix tc[V][V] such that tc[u][v] would be true if v is reachable from u.

# Important links

1. http://www.flipkart.com/introduction-algorithms-8120340078/p/itmczynzhyhxv2gs?pid=9788120340077&affid=sandeepgfg
2. http://www.cs.princeton.edu/courses/archive/spr03/cs226/lectures/digraph.4up.pdf