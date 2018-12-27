class Solution {
    
    
    class Graph {
        int V;
        List<List<Node>> list;
        
        Graph(int V) {
            this.V = V;
            list = new ArrayList<List<Node>>();
            for(int i = 0; i < V; i++) {
                List<Node> vertex = new ArrayList<Node>();
                list.add(vertex);
            }
            
        }
        
        public void addDirectedEdge(int u, int v, int w) {
            Node new_node = new Node(v, w);
            this.list.get(u).add(new_node);
        }
        
        public void printAdjacencyList() {
            for(int i = 0; i < V; i++) {
                List<Node> vertices = list.get(i);
                System.out.print("Vertice " + i + " ");
                for(Node vertice : vertices) {
                    System.out.print(" -> " + vertice.v + " " + vertice.w);
                }
                System.out.println();
            }
        }
        
        public int bfs(int K) {
		
            boolean[] visited = new boolean[V];
            Queue<Integer> queue = new LinkedList<Integer>();

            int vertex = K;

            queue.offer(vertex);
            visited[vertex] = true;

            int result = 0;
            
            while(!queue.isEmpty()) {
                Integer i = queue.poll();
                // System.out.print(i + " ");
                List<Node> innerList = list.get(i);
                for(int v = 0; v < innerList.size(); v++) {
                    Node n = innerList.get(v);
                    if(!visited[n.v]) {
                        queue.offer(n.v);
                        visited[n.v] = true;
                        result += n.w;
                    }	
                }
            }
            
            for(int i = 0; i < V; i++) {
                if(!visited[i] && list.get(i).size() > 0)
                    return -1;
            }
            
            return result;
        }
    }
    
    class Node {
        int v;
        int w;
        
        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    
    public int networkDelayTime(int[][] times, int N, int K) {
        
        
        Graph graph = new Graph(N + 1);
        
        
        for(int i = 0; i < times.length; i++) {
            graph.addDirectedEdge(times[i][0], times[i][1], times[i][2]);
        }
        
        graph.printAdjacencyList();

        return graph.bfs(K);
    }
}