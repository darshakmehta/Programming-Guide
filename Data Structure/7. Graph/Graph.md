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

# Facts

[Six degrees of separation](https://en.wikipedia.org/wiki/Six_degrees_of_separation)